package com.tencent.mm.plugin.favorite.a;

import android.content.Context;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.sdk.platformtools.ag;

class e$3 implements Runnable {
    final /* synthetic */ String fgO;
    final /* synthetic */ Runnable fgd;
    final /* synthetic */ uq mpE;
    final /* synthetic */ Context val$context;

    public e$3(uq uqVar, Context context, String str, Runnable runnable) {
        this.mpE = uqVar;
        this.val$context = context;
        this.fgO = str;
        this.fgd = runnable;
    }

    public final void run() {
        if (this.mpE.bjS == 15) {
            e.a(this.val$context, this.fgO, this.mpE);
        } else {
            e.b(this.val$context, this.fgO, this.mpE);
        }
        ag.y(this.fgd);
    }

    public final String toString() {
        return super.toString() + "|sendFavVideo";
    }
}
