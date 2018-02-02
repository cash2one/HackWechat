package com.tencent.mm.plugin.appbrand.app;

import android.os.Looper;

class b$1 implements Runnable {
    b$1() {
    }

    public final void run() {
        Looper.myQueue().addIdleHandler(new 1(this));
    }
}
