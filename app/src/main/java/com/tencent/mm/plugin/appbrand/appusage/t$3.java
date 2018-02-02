package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.plugin.appbrand.config.k.a;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.protocal.c.afq;
import com.tencent.mm.protocal.c.bim;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class t$3 implements Runnable {
    final /* synthetic */ t iKr;
    final /* synthetic */ afq iKt;

    t$3(t tVar, afq com_tencent_mm_protocal_c_afq) {
        this.iKr = tVar;
        this.iKt = com_tencent_mm_protocal_c_afq;
    }

    public final void run() {
        if (!bh.cA(this.iKt.wnx)) {
            List linkedList = new LinkedList();
            Iterator it = this.iKt.wnx.iterator();
            while (it.hasNext()) {
                linkedList.add(((bim) it.next()).username);
            }
            r.a(linkedList, a.iOO);
        }
    }
}
