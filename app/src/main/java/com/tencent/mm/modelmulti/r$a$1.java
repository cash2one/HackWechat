package com.tencent.mm.modelmulti;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.plugin.zero.c;
import com.tencent.mm.protocal.c.ol;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

class r$a$1 implements a {
    final /* synthetic */ r.a hHv;

    r$a$1(r.a aVar) {
        this.hHv = aVar;
    }

    public final boolean uF() {
        if (g.Dh().Cy() && !com.tencent.mm.kernel.a.Cs()) {
            g.Dk();
            if (g.Dj() != null) {
                g.Dk();
                if (g.Dj().CU() != null) {
                    LinkedList linkedList = this.hHv.hHr.vRD.ksP;
                    c cVar = new c();
                    cVar.bv(this.hHv.hHt);
                    long Wp = bh.Wp();
                    while (this.hHv.hFo < linkedList.size()) {
                        linkedList.size();
                        if (!cVar.a((ol) linkedList.get(this.hHv.hFo), false)) {
                            d.pPH.a(99, 46, 1, false);
                        }
                        r.a aVar = this.hHv;
                        aVar.hFo++;
                        x.i("MicroMsg.SyncService", "processResp %s time:%s size:%s index:%s", new Object[]{this.hHv.hHt, Long.valueOf(bh.bz(Wp)), Integer.valueOf(linkedList.size()), Integer.valueOf(this.hHv.hFo - 1)});
                        if (bh.bz(Wp) >= 500) {
                            break;
                        }
                    }
                    cVar.bw(this.hHv.hHt);
                    if (this.hHv.hFo < linkedList.size()) {
                        x.i("MicroMsg.SyncService", "processResp %s time:%s size:%s index:%s Shold Continue.", new Object[]{this.hHv.hHt, Long.valueOf(bh.bz(Wp)), Integer.valueOf(linkedList.size()), Integer.valueOf(this.hHv.hFo - 1)});
                        return true;
                    }
                    r.a(this.hHv.hHq, this.hHv.hHr, this.hHv.hHt);
                    this.hHv.hHs.ie(linkedList.size());
                    return false;
                }
            }
        }
        Object[] objArr = new Object[4];
        objArr[0] = this.hHv.hHt;
        objArr[1] = Boolean.valueOf(g.Dh().Cy());
        objArr[2] = Boolean.valueOf(com.tencent.mm.kernel.a.Cs());
        g.Dk();
        objArr[3] = g.Dj();
        x.e("MicroMsg.SyncService", "processResp %s accready:%s hold:%s accstg:%s ", objArr);
        this.hHv.hHs.ie(0);
        return false;
    }
}
