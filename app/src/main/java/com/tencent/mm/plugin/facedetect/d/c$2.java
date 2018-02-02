package com.tencent.mm.plugin.facedetect.d;

import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.TimerTask;

class c$2 extends TimerTask {
    final /* synthetic */ c mhJ;

    c$2(c cVar) {
        this.mhJ = cVar;
    }

    public final void run() {
        synchronized (c.b(this.mhJ)) {
            if (!c.c(this.mhJ)) {
                x.w(c.el(), "hy: already stopped");
                cancel();
            }
            ag.y(new 1(this));
        }
    }
}
