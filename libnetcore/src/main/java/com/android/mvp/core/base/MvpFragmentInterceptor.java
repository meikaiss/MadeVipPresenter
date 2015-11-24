package com.android.mvp.core.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * Created by meikai on 15/11/8.
 */
public class MvpFragmentInterceptor {

    private FragmentActivity fragmentActivity;

    public MvpFragmentInterceptor(FragmentActivity fragmentActivity) {
        this.fragmentActivity = fragmentActivity;
    }

    public void onCreate(Bundle savedInstanceState) {
    }

    public void onStart() {
    }

    public void onRestart() {
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroy() {
    }

    public void onSaveInstanceState(Bundle outState) {
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
    }
}
