package com.tencent.mm.plugin.sns.abtest;

import com.tencent.mm.g.a.pq;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class c$1 extends c<pq> {
    c$1() {
        this.xen = pq.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        pq pqVar = (pq) bVar;
        if (pqVar instanceof pq) {
            boolean z = pqVar.fHs.fHt;
            long j = pqVar.fHs.fwn;
            x.d("MicroMsg.SellerABTestManager", "blockUserEventListener callback, isBlock:%b, snsInfoSvrId:%b", new Object[]{Boolean.valueOf(z), Long.valueOf(j)});
            if (j != 0 && c.boz().contains(Long.valueOf(j))) {
                c.l(j, z);
            }
        }
        return false;
    }
}
