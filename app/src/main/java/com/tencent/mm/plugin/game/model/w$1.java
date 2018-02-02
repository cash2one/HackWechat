package com.tencent.mm.plugin.game.model;

import com.tencent.mm.g.a.tv;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

class w$1 implements Runnable {
    final /* synthetic */ String iGf;
    final /* synthetic */ w ndo;

    w$1(w wVar, String str) {
        this.ndo = wVar;
        this.iGf = str;
    }

    public final void run() {
        if (bh.ov(this.iGf)) {
            x.e("MicroMsg.GameMessageService", "msg content is null");
            return;
        }
        Map y = bi.y(this.iGf, "sysmsg");
        if (y == null || y.size() == 0) {
            x.e("MicroMsg.GameMessageService", "Parse failed");
            return;
        }
        String az = bh.az((String) y.get(".sysmsg.wepkg.$pkg_id"), "");
        x.i("MicroMsg.GameMessageService", "MicroMsg.Wepkg message pkgid:%s", new Object[]{az});
        if (!bh.ov(az)) {
            b tvVar = new tv();
            tvVar.fMD.fpr = 1;
            tvVar.fMD.fME = az;
            a.xef.m(tvVar);
        }
    }
}
