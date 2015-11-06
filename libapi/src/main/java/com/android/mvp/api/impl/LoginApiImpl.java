package com.android.mvp.api.impl;

import com.android.mvp.api.ApiUrlConstant;
import com.android.mvp.api.LoginApi;
import com.android.mvp.api.base.MvpBaseApi;
import com.android.mvp.api.dto.LoginDto;
import com.android.mvp.core.api.ApiResponse;
import com.android.mvp.core.exception.ApiException;
import com.android.mvp.core.exception.HttpException;
import com.android.mvp.core.exception.InternalException;
import com.android.mvp.core.http.MvpNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by meikai on 15/11/4.
 */
public class LoginApiImpl extends MvpBaseApi implements LoginApi {


    @Override
    public boolean login(LoginDto loginDto) throws ApiException, HttpException, InternalException {

        List<MvpNameValuePair> nameValuePairList = new ArrayList<>();
        nameValuePairList.add(new MvpNameValuePair("userName", loginDto.getUserName()));
        nameValuePairList.add(new MvpNameValuePair("userPwd", loginDto.getUserPwd()));

        ApiResponse apiResponse = httpPost(ApiUrlConstant.LOGIN_IN, nameValuePairList);

        return apiResponse.getJsonObject().getBoolean("data");
    }

    @Override
    public boolean logout() throws ApiException, HttpException, InternalException {

        ApiResponse apiResponse = httpPost(ApiUrlConstant.LOGIN_OUT, null);

        return apiResponse.getJsonObject().getBoolean("data");
    }
}
