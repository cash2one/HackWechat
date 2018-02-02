package com.tencent.mm.ui;

import com.tencent.mm.g.a.qq;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.ui.MMAppMgr.8;
import com.tencent.mm.z.ak.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class MMAppMgr$8$1 implements Runnable {
    final /* synthetic */ 8 xJV;

    MMAppMgr$8$1(8 8) {
        this.xJV = 8;
    }

    public final void run() {
        m.UF().run();
        o.TZ().run();
        com.tencent.mm.aq.o.Pu().run();
        an.bYU().run();
        if (a.hfO != null) {
            a.hfO.GS();
        }
        com.tencent.mm.sdk.b.a.xef.m(new qq());
        ar.Hg();
        c.EX().b(null);
    }
}
