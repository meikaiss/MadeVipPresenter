package com.android.mvp.core.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * Created by meikai on 15/11/8.
 */
public class MvpFragmentActivity extends FragmentActivity {

    MvpFragmentInterceptor mvpFragmentInterceptor = new MvpFragmentInterceptor(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mvpFragmentInterceptor.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mvpFragmentInterceptor.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mvpFragmentInterceptor.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mvpFragmentInterceptor.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mvpFragmentInterceptor.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mvpFragmentInterceptor.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mvpFragmentInterceptor.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mvpFragmentInterceptor.onRestoreInstanceState(savedInstanceState);
    }
}
