package com.tencent.mm.plugin.sns.abtest;

import com.tencent.mm.g.a.ge;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class a$2 extends c<ge> {
    a$2() {
        this.xen = ge.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ge geVar = (ge) bVar;
        if (geVar instanceof ge) {
            boolean z = geVar.fwl.fwm;
            long j = geVar.fwl.fwn;
            x.d("MicroMsg.NotInteresetABTestManager", "notInterestFinishEventListener callback, isNotInterest:%b, sndId:%d", Boolean.valueOf(z), Long.valueOf(j));
            if (!(j == 0 || a.aaz() == 0 || j != a.aaz())) {
                if (z) {
                    a.wq(2);
                } else {
                    a.wq(1);
                }
                a.akq();
            }
        }
        return false;
    }
}
