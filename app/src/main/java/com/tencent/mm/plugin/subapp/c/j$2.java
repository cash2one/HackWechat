package com.tencent.mm.plugin.subapp.c;

import android.os.SystemClock;
import com.tencent.mm.sdk.platformtools.x;

class j$2 implements Runnable {
    final /* synthetic */ j rWH;

    j$2(j jVar) {
        this.rWH = jVar;
    }

    public final void run() {
        long currentTimeMillis = System.currentTimeMillis() - j.j(this.rWH);
        x.d("MicroMsg.VoiceRemindService", "Try Run service runningFlag:" + j.e(this.rWH) + " timeWait:" + currentTimeMillis + " sending:" + j.g(this.rWH) + " recving:" + j.f(this.rWH));
        if (j.e(this.rWH)) {
            if (currentTimeMillis >= 60000) {
                x.e("MicroMsg.VoiceRemindService", "ERR: Try Run service runningFlag:" + j.e(this.rWH) + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + j.g(this.rWH) + " recving:" + j.f(this.rWH));
            } else {
                return;
            }
        }
        j.k(this.rWH);
        j.b(this.rWH);
        j.a(this.rWH, 3);
        j.a(this.rWH);
        this.rWH.flX.gHJ = SystemClock.elapsedRealtime();
        j.l(this.rWH).J(10, 10);
    }
}
