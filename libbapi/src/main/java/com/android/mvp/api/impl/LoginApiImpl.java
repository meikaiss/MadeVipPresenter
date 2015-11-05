package com.android.mvp.api.impl;

import com.android.mvp.api.ApiUrlConstant;
import com.android.mvp.api.LoginApi;
import com.android.mvp.core.api.ApiResponse;
import com.android.mvp.core.api.BaesApi;
import com.android.mvp.core.exception.ApiException;
import com.android.mvp.core.exception.HttpException;
import com.android.mvp.core.exception.InternalException;

/**
 * Created by meikai on 15/11/4.
 */
public class LoginApiImpl extends BaesApi implements LoginApi {


    @Override
    public void login() throws ApiException, HttpException, InternalException {

        ApiResponse apiResponse = httpGet(ApiUrlConstant.LOGIN_IN) ;
    }

    @Override
    public void logOut() throws ApiException, HttpException, InternalException {

        ApiResponse apiResponse = httpGet(ApiUrlConstant.LOGIN_IN) ;
    }
}
