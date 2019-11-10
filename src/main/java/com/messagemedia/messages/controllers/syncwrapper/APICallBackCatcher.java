package com.messagemedia.messages.controllers.syncwrapper;

import com.messagemedia.messages.http.client.APICallBack;
import com.messagemedia.messages.http.client.HttpContext;

// TODO: Auto-generated Javadoc
/**
 * An APICallBack that captures the HTTP response and can be waited on
 *
 * An instance of this class can be passed to an API call as the APICallBack
 * instance to capture the results of that call. Call await() to block until
 * completion of the API call. Trying to get results of API call before 
 * calling wait() will also block.
 *  
 * @param <T> Type of the response object
 */
public class APICallBackCatcher<T> extends SynchronousBase implements APICallBack<T> {
    
    /** The result. */
    private T result = null;
    
    /** The error. */
    private Throwable error = null;
    
    /** The success. */
    private boolean success = false;

    /**
     * Get the result from the API callback.
     * Blocks if API call is not complete yet.
     *
     * @return the result
     * @throws Throwable the throwable
     */
    public T getResult() throws Throwable {
        await();
        return result;
    }

    /**
     * Set API callback result.
     *
     * @param response the new result
     */
    private void setResult(T response) {
        this.result = response;
    }

    /**
     * Get the exception object thrown by this API callback if any.
     * Blocks if API call is not complete yet.
     *
     * @return the error
     * @throws InterruptedException the interrupted exception
     */
    public Throwable getError() throws InterruptedException {
        await();
        return error;
    }

    /**
     * Set the exception object.
     *
     * @param error the new error
     */
    private void setError(Throwable error) {
        this.error = error;
    }

    /**
     * Was the API call successful?
     * Blocks if API call is not complete yet.
     *
     * @return true, if is success
     * @throws InterruptedException the interrupted exception
     */
    public boolean isSuccess() throws InterruptedException {
        await();
        return success;
    }

    /**
     * Set the success for API call.
     *
     * @param success the new success
     */
    private void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * On Success handler for APICallBack.
     *
     * @param context the context
     * @param response the response
     */
    public void onSuccess(HttpContext context, T response) {
        setResult(response);
        setSuccess(true);
        setError(null);
        markAsDone();
    }

    /**
     * OnFailure handler for APICallBack.
     *
     * @param responseContext the response context
     * @param error the error
     */
    public void onFailure(HttpContext responseContext, Throwable error) {
        setResult(null);
        setSuccess(false);
        setError(error);
        markAsDone();
    }
}

