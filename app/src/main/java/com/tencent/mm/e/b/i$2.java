package com.tencent.mm.e.b;

import android.os.SystemClock;
import com.tencent.mm.sdk.platformtools.x;

class i$2 implements Runnable {
    final /* synthetic */ i fmc;

    i$2(i iVar) {
        this.fmc = iVar;
    }

    public final void run() {
        long currentTimeMillis = System.currentTimeMillis() - i.j(this.fmc);
        x.i("MicroMsg.SceneVoiceService", "Try Run service runningFlag:" + i.e(this.fmc) + " timeWait:" + currentTimeMillis + " sending:" + i.g(this.fmc) + " recving:" + i.f(this.fmc));
        if (i.e(this.fmc)) {
            if (currentTimeMillis >= 60000) {
                x.e("MicroMsg.SceneVoiceService", "ERR: Try Run service runningFlag:" + i.e(this.fmc) + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + i.g(this.fmc) + " recving:" + i.f(this.fmc));
            } else {
                return;
            }
        }
        i.k(this.fmc);
        i.b(this.fmc);
        i.a(this.fmc, 3);
        i.a(this.fmc);
        this.fmc.flX.gHJ = SystemClock.elapsedRealtime();
        i.l(this.fmc).J(10, 10);
    }

    public final String toString() {
        return super.toString() + "|run";
    }
}
