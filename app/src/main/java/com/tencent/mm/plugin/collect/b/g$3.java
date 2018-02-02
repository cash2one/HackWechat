package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class g$3 implements Runnable {
    final /* synthetic */ g liu;

    g$3(g gVar) {
        this.liu = gVar;
    }

    public final void run() {
        if (g.a(this.liu) != null && g.b(this.liu) && g.c(this.liu) == null) {
            x.i("MicroMsg.F2fRcvVoiceListener", "this play may error");
            g.pQN.a(699, 1, 1, false);
        }
    }
}
