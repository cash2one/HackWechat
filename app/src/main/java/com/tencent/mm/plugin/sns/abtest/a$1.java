package com.tencent.mm.plugin.sns.abtest;

import com.tencent.mm.g.a.pq;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class a$1 extends c<pq> {
    a$1() {
        this.xen = pq.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        pq pqVar = (pq) bVar;
        if (pqVar instanceof pq) {
            boolean z = pqVar.fHs.fHt;
            long j = pqVar.fHs.fwn;
            x.d("MicroMsg.NotInteresetABTestManager", "blockUserEventListener callback, isBlock:%b, snsInfoSvrId:%b", Boolean.valueOf(z), Long.valueOf(j));
            if (!(j == 0 || a.aaz() == 0 || a.aaz() != j)) {
                if (z) {
                    a.wq(4);
                } else {
                    a.wq(3);
                }
                a.akq();
            }
        }
        return false;
    }
}
