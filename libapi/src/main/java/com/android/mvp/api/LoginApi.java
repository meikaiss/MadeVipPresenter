package com.android.mvp.api;

import com.android.mvp.api.dto.LoginDto;
import com.android.mvp.core.exception.ApiException;
import com.android.mvp.core.exception.HttpException;
import com.android.mvp.core.exception.InternalException;

/**
 * Created by meikai on 15/11/4.
 */
public interface LoginApi {

    boolean login(LoginDto loginDto) throws ApiException, HttpException, InternalException;

    boolean logout() throws ApiException, HttpException, InternalException;
}
