package com.messagemedia.messages.controllers.syncwrapper;

import com.messagemedia.messages.http.client.APICallBack;
import com.messagemedia.messages.http.client.HttpContext;


public class APICallBackCatcher<T> extends SynchronousBase implements APICallBack<T> {
    
    private T result = null;
    private Throwable error = null;
    private boolean success = false;


    public T getResult() throws Throwable {
        await();
        return result;
    }


    private void setResult(T response) {
        this.result = response;
    }

 
    public Throwable getError() throws InterruptedException {
        await();
        return error;
    }


    private void setError(Throwable error) {
        this.error = error;
    }

 
    public boolean isSuccess() throws InterruptedException {
        await();
        return success;
    }

 
    private void setSuccess(boolean success) {
        this.success = success;
    }


    public void onSuccess(HttpContext context, T response) {
        setResult(response);
        setSuccess(true);
        setError(null);
        markAsDone();
    }

 
    public void onFailure(HttpContext responseContext, Throwable error) {
        setResult(null);
        setSuccess(false);
        setError(error);
        markAsDone();
    }
}

