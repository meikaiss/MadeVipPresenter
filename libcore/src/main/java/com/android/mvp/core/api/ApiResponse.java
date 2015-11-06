package com.android.mvp.core.api;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by meikai on 15/11/4.
 */
public class ApiResponse {

    private boolean success;
    private int errorCode;
    private String message;
    private JSONObject jsonObject;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    public void setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public ApiResponse() {
    }

    public ApiResponse(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
        this.success = jsonObject.getBooleanValue("success");
        this.errorCode = jsonObject.getIntValue("errorCode");
        this.message = jsonObject.getString("message");
    }

    public <T> T getData(Class<T> cls){
        return getData("data", cls);
    }

    public <T> T getData(String path, Class<T> cls){
        String[] ss = path.split("\\.");
        JSONObject json = this.jsonObject;
        String[] arr$ = ss;
        int len$ = ss.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            String s = arr$[i$];
            json = json.getJSONObject(s);
        }

        return JSON.toJavaObject(json, cls);
    }

    public <T> List<T> getDataArray(Class<T> cls) {
        return this.getDataArray("data.itemList", cls);
    }

    public <T> List<T> getDataArray(String path, Class<T> cls) {
        ArrayList list = new ArrayList();
        String[] ss = path.split("\\.");
        JSONObject json = this.jsonObject;

        for(int array = 0; array < ss.length - 1; ++array) {
            json = json.getJSONObject(ss[array]);
        }

        JSONArray var8 = json.getJSONArray(ss[ss.length - 1]);

        for(int i = 0; i < var8.size(); ++i) {
            list.add(var8.getObject(i, cls));
        }

        return list;
    }


}
