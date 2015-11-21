package com.android.mvp.api.context;

import android.app.Activity;

import com.android.mvp.core.context.WeakRefLostException;

/**
 * Created by meikai on 15/11/21.
 */
public abstract class MvpActivityBaseApiContext<A extends Activity, T> extends MvpBaseApiContext<A, T> {

    public MvpActivityBaseApiContext(A a) {
        super(a);
    }

    @Override
    protected A get() {
        A activity = super.get();
        if(activity.isFinishing()){
            throw new WeakRefLostException(" activity is finishing ");
        }

        return activity;
    }
}
