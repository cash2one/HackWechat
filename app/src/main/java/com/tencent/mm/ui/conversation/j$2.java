package com.tencent.mm.ui.conversation;

import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class j$2 implements Runnable {
    final /* synthetic */ j yZL;

    j$2(j jVar) {
        this.yZL = jVar;
    }

    public final void run() {
        Object c = j.c(this.yZL);
        x.i("MicroMsg.BannerHelper", "destroyBanner");
        a.dB(c.yVK);
        a.dB(c.yVL);
        a.dB(c.yVM);
        a.dB(c.yVN);
        for (b bVar : c.yVO) {
            if (bVar != null) {
                bVar.destroy();
            }
        }
        ar.b(c.pUH);
        a.xef.c(c.yVP);
        a.xef.c(c.yVQ);
        if (ar.Hj()) {
            ar.Hg();
            c.b(c);
        }
        c.context = null;
    }
}
