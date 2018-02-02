package com.tencent.mm.ui.conversation;

import com.tencent.mm.ad.n;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class j$10 implements Runnable {
    final /* synthetic */ j yZL;

    j$10(j jVar) {
        this.yZL = jVar;
    }

    public final void run() {
        Object c = j.c(this.yZL);
        x.i("MicroMsg.BannerHelper", "releaseBanner");
        a.dA(c.yVK);
        a.dA(c.yVL);
        a.dA(c.yVM);
        a.dA(c.yVN);
        for (b bVar : c.yVO) {
            if (bVar != null) {
                bVar.release();
            }
        }
        if (ar.Hj()) {
            n.Jz().e(c);
        }
        if (ar.Hj()) {
            ar.Hg();
            c.CU().b(c);
        }
    }
}
