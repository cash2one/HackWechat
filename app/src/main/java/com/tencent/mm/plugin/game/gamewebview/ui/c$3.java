package com.tencent.mm.plugin.game.gamewebview.ui;

import com.tencent.mm.plugin.game.gamewebview.ui.b.a;
import com.tencent.mm.sdk.platformtools.x;

class c$3 implements a {
    final /* synthetic */ boolean[] jDq;
    final /* synthetic */ Runnable jDt;
    final /* synthetic */ c mYA;

    c$3(c cVar, boolean[] zArr, Runnable runnable) {
        this.mYA = cVar;
        this.jDq = zArr;
        this.jDt = runnable;
    }

    public final void ajQ() {
        x.d("MicroMsg.GameWebPageContainer", "onLoadFinish, costTime = %d", new Object[]{Long.valueOf(System.currentTimeMillis() - c.b(this.mYA))});
        if (!this.jDq[0]) {
            x.d("MicroMsg.GameWebPageContainer", "removeCallback, %d", new Object[]{Integer.valueOf(this.jDt.hashCode())});
            this.mYA.removeCallbacks(this.jDt);
            this.mYA.post(this.jDt);
        }
    }
}
