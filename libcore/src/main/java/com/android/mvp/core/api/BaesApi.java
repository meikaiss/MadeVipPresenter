package com.android.mvp.core.api;

import com.android.mvp.core.exception.ApiException;
import com.android.mvp.core.exception.HttpException;
import com.android.mvp.core.exception.InternalException;
import com.android.mvp.core.utils.MvpUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

/**
 * Created by meikai on 15/11/4.
 */
public abstract class BaesApi {

    protected abstract String getApiHost();

    protected abstract String getSignKey();

    protected Map<String, String> getExtraParams() {
        return null;
    }


    protected ApiResponse httpGet(String url) throws ApiException, HttpException, InternalException {
        url = buildFullUrl(url);

        ApiResponse response = new ApiResponse(null);

        return  response;
    }

    protected String buildFullUrl(String url){
        StringBuilder sb = new StringBuilder(url);

        HashMap paramHashMap = new HashMap();
        paramHashMap.put("_r", UUID.randomUUID().toString().replaceAll("-", ""));

        Map extraMap = this.getExtraParams();
        if(MvpUtils.isNotEmpty(extraMap)){
            Iterator iterator = extraMap.keySet().iterator();
            while (iterator.hasNext()){
                Map.Entry entry = (Map.Entry) iterator.next();
                paramHashMap.put(entry.getKey(), entry.getValue());
            }
        }



        return this.getApiHost() + sb.toString();
    }

    public static enum HttpMethod{
        Post,
        Get;

        private HttpMethod(){

        }
    }
}
