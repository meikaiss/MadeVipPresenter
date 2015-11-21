package com.android.mvp.core.context;

import android.app.Activity;

/**
 * Created by meikai on 15/11/21.
 */
public abstract class BaseActivityApiContext<A extends Activity, T> extends BaseApiContext<A, T> {

    public BaseActivityApiContext(A a) {
        super(a);
    }

    @Override
    protected A get() {
        A a = super.get();
        if(a.isFinishing()){
            throw new ActivityFinishException("activity is finishing");
        }
        return a;
    }
}
