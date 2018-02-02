package com.tencent.mm.av;

import com.tencent.mm.g.a.jr;
import com.tencent.mm.protocal.c.asv;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;

class b$8 implements Runnable {
    final /* synthetic */ asv hHS;

    b$8(asv com_tencent_mm_protocal_c_asv) {
        this.hHS = com_tencent_mm_protocal_c_asv;
    }

    public final void run() {
        b jrVar = new jr();
        jrVar.fAt.action = 3;
        jrVar.fAt.fAv = this.hHS;
        a.xef.m(jrVar);
    }
}
