package com.android.mvp.core.context;

/**
 * Created by meikai on 15/11/21.
 */
public class ActivityFinishException extends RuntimeException {

    public ActivityFinishException() {
    }

    public ActivityFinishException(String detailMessage) {
        super(detailMessage);
    }

    public ActivityFinishException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public ActivityFinishException(Throwable throwable) {
        super(throwable);
    }
}
