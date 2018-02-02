package com.tencent.mm.plugin.sight.decode.a;

import com.tencent.mm.modelvideo.o;
import com.tencent.mm.sdk.platformtools.x;

class b$c implements Runnable {
    volatile boolean otH = false;
    final /* synthetic */ b qtU;
    int quc;
    b$b qud;

    public b$c(b bVar) {
        this.qtU = bVar;
        x.i("MicroMsg.SightPlayController", "make sure drawJob alive");
    }

    public final void run() {
        if (this.otH) {
            x.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop draw", new Object[]{Integer.valueOf(this.qtU.hashCode()), Integer.valueOf(hashCode())});
            return;
        }
        this.qtU.D(b.B(this.qtU));
        if (b.r(this.qtU) == 0) {
            o.c(this.qud, 0);
            return;
        }
        long currentTimeMillis = ((long) this.qtU.qto) - (System.currentTimeMillis() - b.r(this.qtU));
        if (currentTimeMillis > 0) {
            o.c(this.qud, currentTimeMillis);
        } else {
            o.c(this.qud, 0);
        }
    }
}
