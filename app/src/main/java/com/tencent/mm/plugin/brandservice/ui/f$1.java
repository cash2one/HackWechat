package com.tencent.mm.plugin.brandservice.ui;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.je;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.sortview.a;

class f$1 implements c$b {
    final /* synthetic */ f kGS;

    f$1(f fVar) {
        this.kGS = fVar;
    }

    public final void a(c cVar, a aVar, int i, String str, int i2, int i3) {
        je nt = this.kGS.nt(i3);
        String str2 = bh.ou(this.kGS.kFl) + "," + i + "," + bh.ou(str) + "," + i2 + "," + cVar.kFv + "," + (nt == null ? "" : nt.vPs + ",0");
        g.pQN.k(10866, str2);
        x.d("MicroMsg.SearchOrRecommendBizAdapter", "report : " + str2);
    }
}
