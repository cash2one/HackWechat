package com.tencent.mm.plugin.appbrand.b;

import android.os.Looper;

class c$6 implements Runnable {
    final /* synthetic */ c iHj;

    c$6(c cVar) {
        this.iHj = cVar;
    }

    public final void run() {
        Looper.myQueue().addIdleHandler(new 1(this));
    }
}
