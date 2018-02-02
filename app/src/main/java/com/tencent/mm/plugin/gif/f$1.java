package com.tencent.mm.plugin.gif;

import android.os.SystemClock;

class f$1 implements Runnable {
    final /* synthetic */ f nzv;

    f$1(f fVar) {
        this.nzv = fVar;
    }

    public final void run() {
        if (!f.a(this.nzv)) {
            if ((this.nzv.isRunning() || f.b(this.nzv) == 0) && SystemClock.uptimeMillis() >= f.c(this.nzv)) {
                f.a(this.nzv, System.currentTimeMillis());
                this.nzv.invalidateSelf();
            }
        }
    }
}
