package com.android.mvp.core.exception;

/**
 * Created by meikai on 15/11/4.
 */
public class InternalException extends FallbackException {
    public InternalException() {
    }

    public InternalException(String detailMessage) {
        super(detailMessage);
    }

    public InternalException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public InternalException(Throwable throwable) {
        super(throwable);
    }
}
