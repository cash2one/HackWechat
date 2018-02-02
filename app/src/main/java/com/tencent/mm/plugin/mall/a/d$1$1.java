package com.tencent.mm.plugin.mall.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.mall.a.d.1;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;

class d$1$1 implements Runnable {
    final /* synthetic */ String iGf;
    final /* synthetic */ 1 okY;

    d$1$1(1 1, String str) {
        this.okY = 1;
        this.iGf = str;
    }

    public final void run() {
        c bMe = c.bMe();
        String str = this.iGf;
        MallNews Nc = c.Nc(str);
        if (Nc == null) {
            return;
        }
        if ("2".equals(Nc.type)) {
            x.d("MicroMsg.MallNewsManager", "removeNews : " + Nc);
            MallNews mallNews = (MallNews) bMe.sQL.get(Nc.sQB);
            if (mallNews != null && mallNews.rVK.equals(Nc.rVK) && mallNews.frP.equals(Nc.frP)) {
                x.i("MicroMsg.MallNewsManager", "onRecieveMsg remove : " + Nc.sQB);
                bMe.sQL.remove(Nc.sQB);
                return;
            }
            x.i("MicroMsg.MallNewsManager", "onRecieveMsg cancel not found!");
            return;
        }
        bMe.sQL.put(Nc.sQB, Nc);
        x.i("MicroMsg.MallNewsManager", "onRecieveMsg : " + str);
        bMe.bjh();
        if (c.a(Nc)) {
            x.i("MicroMsg.MallNewsManager", "set OutOfDateRedDot");
            return;
        }
        if (Nc.showType == 0) {
            x.d("MicroMsg.MallNewsManager", "showType New");
            com.tencent.mm.s.c.Bq().o(262156, true);
            g.Dk();
            g.Dj().CU().a(a.xvO, Long.valueOf(System.currentTimeMillis()));
        } else if (Nc.showType == 1) {
            x.d("MicroMsg.MallNewsManager", "showType Dot");
            com.tencent.mm.s.c.Bq().p(262156, true);
            g.Dk();
            g.Dj().CU().a(a.xvO, Long.valueOf(System.currentTimeMillis()));
        }
        c.bMg();
    }
}
