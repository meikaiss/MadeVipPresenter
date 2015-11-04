package com.android.mvp.core.api;


import com.alibaba.fastjson.JSONObject;

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


}
