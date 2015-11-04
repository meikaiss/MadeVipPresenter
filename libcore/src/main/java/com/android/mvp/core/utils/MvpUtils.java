package com.android.mvp.core.utils;

import android.widget.Toast;

import com.android.mvp.core.MvpCore;

/**
 * Created by meikai on 15/11/4.
 */
public class MvpUtils {

    public static void showToast(String msg){
        Toast.makeText(MvpCore.getApplication(), msg, Toast.LENGTH_SHORT).show();
    }
}
