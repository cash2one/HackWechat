package com.tencent.mm.plugin.favorite.a;

import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class a$1 implements Runnable {
    final /* synthetic */ a mpx;

    a$1(a aVar) {
        this.mpx = aVar;
    }

    public final void run() {
        h.getFavItemInfoStorage().aIh();
        a.a(this.mpx, System.currentTimeMillis());
        x.d("MicroMsg.FavCleanFirstLoader", "calDataBaseDataTotalLength, used: %dms", new Object[]{Long.valueOf(a.a(this.mpx) - a.b(this.mpx))});
        a.a(this.mpx, -1);
        a.c(this.mpx);
        synchronized (a.d(this.mpx)) {
            ar.Hg();
            c.CU().a(a.xpB, Boolean.valueOf(true));
            a.e(this.mpx);
        }
        this.mpx.mHandler.sendEmptyMessage(0);
    }
}
