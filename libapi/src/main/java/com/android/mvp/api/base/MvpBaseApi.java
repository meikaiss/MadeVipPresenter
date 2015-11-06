package com.android.mvp.api.base;

import com.android.mvp.core.api.ApiResponse;
import com.android.mvp.core.api.BaseApi;
import com.android.mvp.core.exception.ApiException;
import com.android.mvp.core.exception.HttpException;
import com.android.mvp.core.exception.InternalException;

import java.util.List;

/**
 * Created by meikai on 15/11/6.
 */
public abstract class MvpBaseApi extends BaseApi {

    @Override
    protected String getApiHost() {
        return "http://192.168.1.200/";
    }

    @Override
    protected String getSignKey() {
        return "MvpDemo";
    }

    protected <T> T httpGetData(String url, Class<T> cls) throws ApiException, HttpException, InternalException {

        ApiResponse apiResponse = this.httpGet(url);

        return apiResponse.getData(cls);
    }

    protected <T> List<T> httpGetDataList(String url, Class<T> cls) throws InternalException, ApiException, HttpException {

        ApiResponse apiResponse = this.httpGet(url);

        return apiResponse.getDataArray(cls);
    }


}
