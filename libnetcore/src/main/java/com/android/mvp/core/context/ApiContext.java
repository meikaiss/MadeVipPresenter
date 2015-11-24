package com.android.mvp.core.context;

/**
 * Created by meikai on 15/11/4.
 */
public interface ApiContext<T> {
    T request() throws Exception;

    void onApiSuccess(T var1);

    void onApiFailure(Exception var1);

    void onApiStarted();

    void onApiFinished();
}
