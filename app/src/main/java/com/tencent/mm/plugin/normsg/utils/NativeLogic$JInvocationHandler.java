package com.tencent.mm.plugin.normsg.utils;

import android.support.annotation.Keep;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Keep
final class NativeLogic$JInvocationHandler implements InvocationHandler {
    @Keep
    private volatile long mCInstancePtr;

    private native void nativeCleanup();

    public final native Object invoke(Object obj, Method method, Object[] objArr);

    private NativeLogic$JInvocationHandler(long j) {
        if (j == 0) {
            throw new IllegalArgumentException("Bad cInstancePtr.");
        }
        this.mCInstancePtr = j;
    }

    protected final void finalize() {
        try {
            nativeCleanup();
            this.mCInstancePtr = 0;
        } catch (Throwable th) {
        } finally {
            super.finalize();
        }
    }
}
