package com.tencent.mm.plugin.favorite.a;

import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.sdk.platformtools.ag;

class e$4 implements Runnable {
    final /* synthetic */ String fgO;
    final /* synthetic */ Runnable fgd;
    final /* synthetic */ f mpD;
    final /* synthetic */ uq mpE;

    e$4(String str, f fVar, uq uqVar, Runnable runnable) {
        this.fgO = str;
        this.mpD = fVar;
        this.mpE = uqVar;
        this.fgd = runnable;
    }

    public final void run() {
        e.a(this.fgO, this.mpD, this.mpE);
        ag.y(this.fgd);
    }

    public final String toString() {
        return super.toString() + "|sendFavFile";
    }
}
