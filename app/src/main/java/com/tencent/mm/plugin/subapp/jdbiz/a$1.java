package com.tencent.mm.plugin.subapp.jdbiz;

import com.tencent.mm.g.a.kl;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;

class a$1 extends c<kl> {
    final /* synthetic */ a rVH;

    a$1(a aVar) {
        this.rVH = aVar;
        this.xen = kl.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        kl klVar = (kl) bVar;
        if ((klVar instanceof kl) && klVar.fBJ.fBL != null && klVar.fBJ.fBK != null && "bizjd".equals(klVar.fBJ.fBK)) {
            String az = bh.az(klVar.fBJ.fBL.getString("activity_id"), "");
            String az2 = bh.az(klVar.fBJ.fBL.getString("jump_url"), "");
            g.pQN.h(11179, new Object[]{az2, c.bDO().bDT().rVK, Integer.valueOf(4)});
            b bDT = c.bDO().bDT();
            if (!(bDT == null || bDT.rVK == null || !bDT.rVK.equals(az))) {
                c.bDO().bDS();
                c.bDO().bDR();
            }
            a.xef.c(this.rVH.rVG);
        }
        return false;
    }
}
