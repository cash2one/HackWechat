package com.tencent.mm.plugin.appbrand.launching.precondition;

import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.q.c;

class b$3 implements Runnable {
    final /* synthetic */ b jyT;
    final /* synthetic */ LaunchParcel jyW;

    b$3(b bVar, LaunchParcel launchParcel) {
        this.jyT = bVar;
        this.jyW = launchParcel;
    }

    public final void run() {
        c.alH();
        new com.tencent.mm.plugin.appbrand.launching.c(this.jyW, new 1(this)).run();
    }
}
