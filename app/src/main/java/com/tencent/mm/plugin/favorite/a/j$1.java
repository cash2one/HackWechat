package com.tencent.mm.plugin.favorite.a;

import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class j$1 implements Runnable {
    final /* synthetic */ f mqs;
    final /* synthetic */ boolean mqt;
    final /* synthetic */ Runnable mqu;

    j$1(f fVar, boolean z, Runnable runnable) {
        this.mqs = fVar;
        this.mqt = z;
        this.mqu = runnable;
    }

    public final void run() {
        x.i("MicroMsg.FavoriteLogic", "delete favItem id %d, localId %d, needBatchDel %B, do on worker thread", Integer.valueOf(this.mqs.field_id), Long.valueOf(this.mqs.field_localId), Boolean.valueOf(this.mqt));
        j.c(this.mqs, this.mqt);
        ag.y(this.mqu);
    }
}
