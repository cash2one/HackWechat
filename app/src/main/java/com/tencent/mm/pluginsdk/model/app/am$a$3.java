package com.tencent.mm.pluginsdk.model.app;

import android.os.SystemClock;
import com.tencent.mm.pluginsdk.model.app.am.a;
import com.tencent.mm.sdk.platformtools.x;

class am$a$3 implements Runnable {
    final /* synthetic */ a vfl;

    am$a$3(a aVar) {
        this.vfl = aVar;
    }

    public final void run() {
        long currentTimeMillis = System.currentTimeMillis() - a.k(this.vfl);
        x.d("MicroMsg.SceneAppMsg", "summerbig Try Run service runningFlag:" + a.f(this.vfl) + " timeWait:" + currentTimeMillis + " sending:" + a.h(this.vfl) + " recving:" + a.g(this.vfl));
        if (a.f(this.vfl)) {
            if (currentTimeMillis >= 180000) {
                x.e("MicroMsg.SceneAppMsg", "summerbig ERR: Try Run service runningFlag:" + a.f(this.vfl) + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + a.h(this.vfl) + " recving:" + a.g(this.vfl));
            } else {
                return;
            }
        }
        a.l(this.vfl);
        a.b(this.vfl);
        a.m(this.vfl);
        a.a(this.vfl);
        this.vfl.flX.gHJ = SystemClock.elapsedRealtime();
        a.n(this.vfl).J(10, 10);
    }

    public final String toString() {
        return super.toString() + "|run";
    }
}
