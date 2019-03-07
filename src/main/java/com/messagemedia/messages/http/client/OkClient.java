package com.messagemedia.messages.http.client;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import com.messagemedia.messages.http.request.HttpBodyRequest;
import com.messagemedia.messages.http.request.HttpMethod;
import com.messagemedia.messages.http.request.HttpRequest;
import com.messagemedia.messages.http.response.HttpResponse;
import com.messagemedia.messages.http.response.HttpStringResponse;
import com.messagemedia.messages.exceptions.APIException;


public class OkClient implements HttpClient {
 
    private static final Object synRoot = new Object();
    private static HttpClient sharedInstance = null;
    private static okhttp3.OkHttpClient client = new okhttp3.OkHttpClient();

 
    public static HttpClient getSharedInstance() {
        if (sharedInstance == null) {
            synchronized(synRoot) {
                if (sharedInstance == null) {
                    sharedInstance = new OkClient();
                }
            }
        }
        return sharedInstance;
    }


    public void setTimeout(long timeout) {
        client = client.newBuilder().connectTimeout(timeout, TimeUnit.MILLISECONDS)
            .writeTimeout(timeout, TimeUnit.MILLISECONDS).readTimeout(timeout, TimeUnit.MILLISECONDS).build();
    }

 
    public void executeAsStringAsync(final HttpRequest httpRequest, final APICallBack<HttpResponse> callBack) {
        okhttp3.Request okHttpRequest = convertRequest(httpRequest);
        client.newCall(okHttpRequest).enqueue(new okhttp3.Callback() {

            public void onFailure(okhttp3.Call call, IOException e) {
                publishResponse(null, httpRequest, callBack, e, false);
            }

            public void onResponse(okhttp3.Call call, okhttp3.Response okHttpResponse) throws IOException {
                publishResponse(okHttpResponse, httpRequest, callBack, null, false);
                okHttpResponse.close();
            }
        });
    }

    public void executeAsBinaryAsync(final HttpRequest httpRequest, final APICallBack<HttpResponse> callBack) {
        okhttp3.Request okHttpRequest = convertRequest(httpRequest);
        client.newCall(okHttpRequest).enqueue(new okhttp3.Callback() {

            public void onFailure(okhttp3.Call call, IOException e) {
                publishResponse(null, httpRequest, callBack, e, true);
            }

            public void onResponse(okhttp3.Call call, okhttp3.Response okHttpResponse) throws IOException {
                publishResponse(okHttpResponse, httpRequest, callBack, null, true);
            }
        });
    }

 
    public HttpResponse executeAsString(HttpRequest httpRequest) throws APIException {
        okhttp3.Request okHttpRequest = convertRequest(httpRequest);
        try {
            okhttp3.Response okHttpResponse = client.newCall(okHttpRequest).execute();
            return convertResponse(okHttpResponse, false);
        } catch (IOException e) {
            throw new APIException(e.getMessage());
        }
    }


    public HttpResponse executeAsBinary(HttpRequest httpRequest) throws APIException {
        okhttp3.Request okHttpRequest = convertRequest(httpRequest);
        try {
            okhttp3.Response okHttpResponse = client.newCall(okHttpRequest).execute();
            return convertResponse(okHttpResponse, true);
        } catch (IOException e) {
            throw new APIException(e.getMessage());
        }
    }


    protected static void publishResponse(okhttp3.Response okHttpResponse, HttpRequest httpRequest,
            APICallBack<HttpResponse> completionBlock, Throwable error, boolean binaryResponse) {
        try {
            HttpResponse httpResponse = (okHttpResponse == null) ? null
                    : OkClient.convertResponse(okHttpResponse, binaryResponse);
            HttpContext context = new HttpContext(httpRequest, httpResponse);

            // if there are no errors, pass on to the callback function
            if (error == null && httpResponse != null) {
                completionBlock.onSuccess(context, httpResponse);
            } else {
                completionBlock.onFailure(context, new APIException(error.getMessage()));
            }

        } catch (IOException e) {
            completionBlock.onFailure(null, new APIException(e.getMessage()));
        }
    }


    public static HttpResponse convertResponse(okhttp3.Response response, boolean binaryResponse) throws IOException {
        HttpResponse httpResponse = null;

        if (null == response) {
            return null;
        }

        okhttp3.ResponseBody responseBody = response.body();

        String responseString;
        InputStream responseStream;

        if (binaryResponse) {
            responseString = "binary response";
            responseStream = responseBody.byteStream();
        } else {
            responseString = responseBody.string();
            responseStream = new ByteArrayInputStream(responseString.getBytes());

            responseBody.close();
            response.close();
        }

        Map<String, String> headers = new HashMap<String, String>();
        for (Entry<String, List<String>> kv : response.headers().toMultimap().entrySet())
            headers.put(kv.getKey(), kv.getValue().get(0));

        httpResponse = new HttpStringResponse(response.code(), headers, responseStream, responseString);
        return httpResponse;
    }

  
    private okhttp3.Request convertRequest(HttpRequest httpRequest) {
        String url = httpRequest.getQueryUrl();

        okhttp3.RequestBody requestBody;

        if (httpRequest instanceof HttpBodyRequest) {

            // set request media type
            String contentType;
            if (!httpRequest.getHeaders().containsKey("content-type"))
                httpRequest.getHeaders().put("content-type", "application/json; charset=UTF-8");
            contentType = httpRequest.getHeaders().get("content-type");

            // set request body
            requestBody = okhttp3.RequestBody.create(okhttp3.MediaType.parse(contentType),
                    ((HttpBodyRequest) httpRequest).getBody().getBytes());
        } else {

            List<SimpleEntry<String, Object>> parameters = httpRequest.getParameters();
            boolean multipartRequest = false;

            // set request fields
            if (parameters != null && parameters.size() > 0) {
                okhttp3.MultipartBody.Builder multipartBuilder = new okhttp3.MultipartBody.Builder()
                        .setType(okhttp3.MultipartBody.FORM);
                okhttp3.FormBody.Builder formBuilder = new okhttp3.FormBody.Builder();

                for (SimpleEntry<String, Object> param : parameters) {
                    if (param.getValue() instanceof File) {
                        multipartRequest = true;
                        multipartBuilder.addFormDataPart(param.getKey(), ((File) param.getValue()).getName(),
                                okhttp3.RequestBody.create(okhttp3.MultipartBody.FORM, (File) param.getValue()));
                    } else {
                        multipartBuilder.addFormDataPart(param.getKey(),
                                (param.getValue() == null) ? "" : param.getValue().toString());
                        formBuilder.add(param.getKey(), (param.getValue() == null) ? "" : param.getValue().toString());
                    }
                }
                // make a multipart request if a file is being sent
                if (multipartRequest) {
                    requestBody = multipartBuilder.build();
                } else {
                    requestBody = formBuilder.build();
                }
            } else if (httpRequest.getHttpMethod().equals(HttpMethod.GET)) {
                requestBody = null;
            } else {
                requestBody = okhttp3.RequestBody.create(null, new byte[0]);
            }
        }

        // set request headers
        okhttp3.Headers.Builder requestHeaders = new okhttp3.Headers.Builder();
        if (httpRequest.getHeaders() != null) {
            for (Entry<String, String> kv : httpRequest.getHeaders().entrySet()) {
                requestHeaders.add(kv.getKey(), kv.getValue());
            }
        }

        // set basic auth credentials if needed
        if ((null != httpRequest.getUsername()) && (!httpRequest.getUsername().isEmpty())) {
            String credentials = okhttp3.Credentials.basic(httpRequest.getUsername(), httpRequest.getPassword());
            requestHeaders.add("Authorization", credentials);
        }

        // build the request
        okhttp3.Request okHttpRequest = new okhttp3.Request.Builder()
                .method(httpRequest.getHttpMethod().toString(), requestBody).headers(requestHeaders.build()).url(url)
                .build();

        return okHttpRequest;
    }

   
    public HttpRequest get(String _queryUrl, Map<String, String> _headers,
            List<SimpleEntry<String, Object>> _parameters, String _username, String _password) {
        return new HttpRequest(HttpMethod.GET, _queryUrl, _headers, _parameters, _username, _password);
    }

 
    public HttpRequest get(String _queryUrl, Map<String, String> _headers,
            List<SimpleEntry<String, Object>> _parameters) {
        return new HttpRequest(HttpMethod.GET, _queryUrl, _headers, _parameters);
    }

  
    public HttpRequest head(String _queryUrl, Map<String, String> _headers,
            List<SimpleEntry<String, Object>> _parameters, String _username, String _password) {
        return new HttpRequest(HttpMethod.HEAD, _queryUrl, _headers, _parameters, _username, _password);
    }

 
    public HttpRequest head(String _queryUrl, Map<String, String> _headers,
            List<SimpleEntry<String, Object>> _parameters) {
        return new HttpRequest(HttpMethod.HEAD, _queryUrl, _headers, _parameters);
    }

  
    public HttpRequest post(String _queryUrl, Map<String, String> _headers,
            List<SimpleEntry<String, Object>> _parameters) {
        return new HttpRequest(HttpMethod.POST, _queryUrl, _headers, _parameters);
    }

 
    public HttpRequest post(String _queryUrl, Map<String, String> _headers,
            List<SimpleEntry<String, Object>> _parameters, String _username, String _password) {
        return new HttpRequest(HttpMethod.POST, _queryUrl, _headers, _parameters, _username, _password);
    }

 
    public HttpBodyRequest postBody(String _queryUrl, Map<String, String> _headers, String _body) {
        return new HttpBodyRequest(HttpMethod.POST, _queryUrl, _headers, _body);
    }


    public HttpBodyRequest postBody(String _queryUrl, Map<String, String> _headers, String _body, String _username,
            String _password) {
        return new HttpBodyRequest(HttpMethod.POST, _queryUrl, _headers, _body, _username, _password);
    }


    public HttpRequest put(String _queryUrl, Map<String, String> _headers,
            List<SimpleEntry<String, Object>> _parameters) {
        return new HttpRequest(HttpMethod.PUT, _queryUrl, _headers, _parameters);
    }

   
    public HttpRequest put(String _queryUrl, Map<String, String> _headers,
            List<SimpleEntry<String, Object>> _parameters, String _username, String _password) {
        return new HttpRequest(HttpMethod.PUT, _queryUrl, _headers, _parameters, _username, _password);
    }

  
    public HttpBodyRequest putBody(String _queryUrl, Map<String, String> _headers, String _body) {
        return new HttpBodyRequest(HttpMethod.PUT, _queryUrl, _headers, _body);
    }


    public HttpBodyRequest putBody(String _queryUrl, Map<String, String> _headers, String _body, String _username,
            String _password) {
        return new HttpBodyRequest(HttpMethod.PUT, _queryUrl, _headers, _body, _username, _password);
    }

 
    public HttpRequest patch(String _queryUrl, Map<String, String> _headers,
            List<SimpleEntry<String, Object>> _parameters) {
        return new HttpRequest(HttpMethod.PATCH, _queryUrl, _headers, _parameters);
    }

  
    public HttpRequest patch(String _queryUrl, Map<String, String> _headers,
            List<SimpleEntry<String, Object>> _parameters, String _username, String _password) {
        return new HttpRequest(HttpMethod.PATCH, _queryUrl, _headers, _parameters, _username, _password);
    }

   
    public HttpBodyRequest patchBody(String _queryUrl, Map<String, String> _headers, String _body) {
        return new HttpBodyRequest(HttpMethod.PATCH, _queryUrl, _headers, _body);
    }

 
    public HttpBodyRequest patchBody(String _queryUrl, Map<String, String> _headers, String _body, String _username,
            String _password) {
        return new HttpBodyRequest(HttpMethod.PATCH, _queryUrl, _headers, _body, _username, _password);
    }

  
    public HttpRequest delete(String _queryUrl, Map<String, String> _headers,
            List<SimpleEntry<String, Object>> _parameters) {
        return new HttpRequest(HttpMethod.DELETE, _queryUrl, _headers, _parameters);
    }


    public HttpRequest delete(String _queryUrl, Map<String, String> _headers,
            List<SimpleEntry<String, Object>> _parameters, String _username, String _password) {
        return new HttpRequest(HttpMethod.DELETE, _queryUrl, _headers, _parameters, _username, _password);
    }

 
    public HttpBodyRequest deleteBody(String _queryUrl, Map<String, String> _headers, String _body) {
        return new HttpBodyRequest(HttpMethod.DELETE, _queryUrl, _headers, _body);
    }

  
    public HttpBodyRequest deleteBody(String _queryUrl, Map<String, String> _headers, String _body, String _username,
            String _password) {
        return new HttpBodyRequest(HttpMethod.DELETE, _queryUrl, _headers, _body, _username, _password);
    }

}
