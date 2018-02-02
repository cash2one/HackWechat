package com.tencent.mm.plugin.appbrand.dynamic.h;

import android.os.Process;

class b$2 implements Runnable {
    b$2() {
    }

    public final void run() {
        Process.killProcess(Process.myPid());
    }
}
