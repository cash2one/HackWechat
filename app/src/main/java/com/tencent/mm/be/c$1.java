package com.tencent.mm.be;

import android.os.Looper;

class c$1 implements Runnable {
    final /* synthetic */ c hPb;

    public c$1(c cVar) {
        this.hPb = cVar;
    }

    public final void run() {
        Looper.myQueue().addIdleHandler(new 1(this));
    }
}
