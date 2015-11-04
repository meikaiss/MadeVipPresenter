package com.android.mvp.core.exception;

/**
 * Created by meikai on 15/11/4.
 */
public class ApiException extends Exception {
    private int errorCode;
    private String message;

    public ApiException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.message = message;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getMessage() {
        return this.message;
    }
}
