package com.tencent.mm.modelvideo;

import android.os.SystemClock;
import com.tencent.mm.sdk.platformtools.x;

class m$3 implements Runnable {
    final /* synthetic */ m hUT;

    m$3(m mVar) {
        this.hUT = mVar;
    }

    public final void run() {
        x.d("MicroMsg.SightMassSendService", "Try Run service runningFlag:" + m.f(this.hUT) + " sending:" + m.g(this.hUT));
        if (!m.f(this.hUT)) {
            m.l(this.hUT);
            m.m(this.hUT).gHJ = SystemClock.elapsedRealtime();
            m.c(this.hUT);
        }
        m.n(this.hUT);
        m.o(this.hUT).J(10, 10);
    }

    public final String toString() {
        return super.toString() + "|run";
    }
}
