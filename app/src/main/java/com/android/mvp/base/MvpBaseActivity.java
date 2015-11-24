package com.android.mvp.base;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by meikai on 15/11/24.
 */
public class MvpBaseActivity extends AppCompatActivity implements BaseUI{








    @Override
    public Context getContext() {
        return this;
    }
}
