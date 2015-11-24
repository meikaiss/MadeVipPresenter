package com.android.mvp.core.http;

/**
 * Created by meikai on 15/11/6.
 */
public class MvpNameValuePair {

    private String name;
    private String value;

    public MvpNameValuePair(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
