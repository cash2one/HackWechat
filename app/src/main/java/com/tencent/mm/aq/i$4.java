package com.tencent.mm.aq;

import android.os.SystemClock;
import com.tencent.mm.sdk.platformtools.x;

class i$4 implements Runnable {
    final /* synthetic */ i hBd;

    i$4(i iVar) {
        this.hBd = iVar;
    }

    public final void run() {
        long currentTimeMillis = System.currentTimeMillis() - i.g(this.hBd);
        if (i.h(this.hBd)) {
            if (currentTimeMillis >= 60000) {
                x.e("MicroMsg.ImgService", "ERR: Try Run service runningFlag:" + i.h(this.hBd) + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + i.h(this.hBd));
            } else {
                return;
            }
        }
        i.i(this.hBd);
        i.j(this.hBd);
        this.hBd.flX.gHJ = SystemClock.elapsedRealtime();
        i.k(this.hBd).J(10, 10);
    }

    public final String toString() {
        return super.toString() + "|run";
    }
}
