package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.b;
import com.tencent.mm.sdk.platformtools.x;

class a$c implements Runnable {
    volatile boolean otH = false;
    int quc;
    final /* synthetic */ a rmk;
    b rmn;

    public a$c(a aVar) {
        this.rmk = aVar;
        x.i("MicroMsg.SightPlayController", "make sure drawJob alive");
    }

    public final void run() {
        if (this.otH) {
            x.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop draw", new Object[]{Integer.valueOf(this.rmk.hashCode()), Integer.valueOf(hashCode())});
            return;
        }
        this.rmk.D(a.B(this.rmk));
        if (a.r(this.rmk) == 0) {
            o.c(this.rmn, 0);
            return;
        }
        long currentTimeMillis = ((long) this.rmk.qto) - (System.currentTimeMillis() - a.r(this.rmk));
        if (currentTimeMillis > 0) {
            o.c(this.rmn, currentTimeMillis);
        } else {
            o.c(this.rmn, 0);
        }
    }
}
