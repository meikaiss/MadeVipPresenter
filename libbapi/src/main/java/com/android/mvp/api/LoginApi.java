package com.android.mvp.api;

import com.android.mvp.core.exception.ApiException;
import com.android.mvp.core.exception.HttpException;
import com.android.mvp.core.exception.InternalException;

/**
 * Created by meikai on 15/11/4.
 */
public interface LoginApi {

    void login() throws ApiException, HttpException, InternalException;

    void logOut() throws ApiException, HttpException, InternalException;
}
