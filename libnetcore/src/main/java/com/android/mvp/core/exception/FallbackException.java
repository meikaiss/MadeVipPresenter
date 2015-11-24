package com.android.mvp.core.exception;

/**
 * Created by meikai on 15/11/4.
 */
public class FallbackException extends Exception {
    public FallbackException() {
    }

    public FallbackException(String detailMessage) {
        super(detailMessage);
    }

    public FallbackException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public FallbackException(Throwable throwable) {
        super(throwable);
    }
}
