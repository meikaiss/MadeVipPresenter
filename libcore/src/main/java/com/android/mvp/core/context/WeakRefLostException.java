package com.android.mvp.core.context;

/**
 * Created by meikai on 15/11/4.
 */
public class WeakRefLostException extends RuntimeException {
    public WeakRefLostException() {
    }

    public WeakRefLostException(String detailMessage) {
        super(detailMessage);
    }

    public WeakRefLostException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public WeakRefLostException(Throwable throwable) {
        super(throwable);
    }
}
