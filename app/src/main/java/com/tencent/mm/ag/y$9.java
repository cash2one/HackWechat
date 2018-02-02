package com.tencent.mm.ag;

import com.tencent.mm.ae.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.bs.a;
import java.util.Map;

class y$9 implements a {
    final /* synthetic */ y hqy;

    y$9(y yVar) {
        this.hqy = yVar;
    }

    public final void a(d.a aVar) {
        bw bwVar = aVar.hmq;
        if (bwVar == null) {
            x.e("MicroMsg.SubCoreBiz", "AddMsg is null.");
            return;
        }
        String a = n.a(bwVar.vGZ);
        if (bh.ov(a)) {
            x.e("MicroMsg.SubCoreBiz", "msg content is null");
            return;
        }
        Map y = bi.y(a, "sysmsg");
        if (y == null || y.size() <= 0) {
            x.e("MicroMsg.SubCoreBiz", "receiveMessage, no sysmsg");
            return;
        }
        if ("mmbizattrappsvr_BizAttrSync".equalsIgnoreCase((String) y.get(".sysmsg.$type"))) {
            x.i("MicroMsg.SubCoreBiz", "BizAttrSync openFlag : %d.", new Object[]{Integer.valueOf(bh.getInt((String) y.get(".sysmsg.mmbizattrappsvr_BizAttrSync.openflag"), 0))});
            g.Dj().CU().a(w.a.xoV, Integer.valueOf(r0));
            g.Dj().CU().lH(true);
            return;
        }
        x.e("MicroMsg.SubCoreBiz", "receiveMessage, type not BizAttrSync.");
    }
}
