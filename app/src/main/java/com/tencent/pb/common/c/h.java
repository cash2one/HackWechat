package com.tencent.pb.common.c;

import android.os.Handler;
import android.os.Looper;

public final class h {
    public static Handler jr = new Handler(Looper.getMainLooper());

    public static void ad(Runnable runnable) {
        if ((Looper.getMainLooper().getThread() == Thread.currentThread() ? 1 : null) != null) {
            runnable.run();
        } else {
            jr.post(runnable);
        }
    }
}
