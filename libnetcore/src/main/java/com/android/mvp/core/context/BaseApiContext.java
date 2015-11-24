package com.android.mvp.core.context;

import java.lang.ref.WeakReference;

/**
 * Created by meikai on 15/11/4.
 */
public abstract class BaseApiContext<A, T> implements ApiContext<T> {
    private WeakReference<A> ref;

    public BaseApiContext(A a) {
        this.ref = new WeakReference(a);
    }

    protected A get() {
        Object a = this.ref.get();
        if(a == null) {
            throw new WeakRefLostException(" a is null ");
        } else {
            return (A) a;
        }
    }

    public void onApiFailure(Exception exception) {
    }

    public void onApiStarted() {
    }

    public void onApiFinished() {
    }
}
