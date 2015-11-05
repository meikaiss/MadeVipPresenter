package com.android.mvp.core.utils;

import android.widget.Toast;

import com.android.mvp.core.MvpCore;

import java.util.Collection;
import java.util.Map;

/**
 * Created by meikai on 15/11/4.
 */
public class MvpUtils {

    public static void showToast(String msg){
        Toast.makeText(MvpCore.getApplication(), msg, Toast.LENGTH_SHORT).show();
    }

    public static boolean isEmpty(String s) {
        return s == null || s.trim().length() == 0;
    }

    public static boolean isEmpty(Collection<?> c) {
        return c == null || c.isEmpty();
    }


    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public static boolean isNotEmpty(String s) {
        return !isEmpty(s);
    }

    public static boolean isNotEmpty(Collection<?> c) {
        return !isEmpty(c);
    }

    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }
}
