package com.tencent.mm.plugin.gif;

import android.os.SystemClock;

class c$2 implements Runnable {
    final /* synthetic */ c nzg;

    c$2(c cVar) {
        this.nzg = cVar;
    }

    public final void run() {
        if ((this.nzg.isRunning() || c.b(this.nzg) == 0) && SystemClock.uptimeMillis() >= c.c(this.nzg)) {
            c.a(this.nzg, System.currentTimeMillis());
            this.nzg.invalidateSelf();
            if (c.a(this.nzg) != null) {
                c.a(this.nzg).invalidate();
            }
        }
    }
}
