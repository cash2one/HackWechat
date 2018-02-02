package com.tencent.mm.plugin.gif;

import android.os.SystemClock;

class d$1 implements Runnable {
    final /* synthetic */ d nzq;

    d$1(d dVar) {
        this.nzq = dVar;
    }

    public final void run() {
        if (SystemClock.uptimeMillis() >= d.a(this.nzq)) {
            this.nzq.invalidateSelf();
        }
    }
}
