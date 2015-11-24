package com.android.mvp.core.exception;

/**
 * Created by meikai on 15/11/4.
 */
public class HttpException extends FallbackException {
    public HttpException() {
    }

    public HttpException(String detailMessage) {
        super(detailMessage);
    }

    public HttpException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public HttpException(Throwable throwable) {
        super(throwable);
    }
}
