package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.protocal.c.afq;
import com.tencent.mm.protocal.c.bim;
import java.util.Iterator;

class t$2 implements Iterator<Object[]> {
    final Object[] iKp = new Object[3];
    final /* synthetic */ t iKr;
    final Iterator<bim> iKs = this.iKt.wnx.iterator();
    final /* synthetic */ afq iKt;

    t$2(t tVar, afq com_tencent_mm_protocal_c_afq) {
        this.iKr = tVar;
        this.iKt = com_tencent_mm_protocal_c_afq;
    }

    public final /* synthetic */ Object next() {
        bim com_tencent_mm_protocal_c_bim = (bim) this.iKs.next();
        this.iKp[0] = com_tencent_mm_protocal_c_bim.username;
        this.iKp[1] = Integer.valueOf(com_tencent_mm_protocal_c_bim.wtc);
        this.iKp[2] = Integer.valueOf(com_tencent_mm_protocal_c_bim.vNa);
        return this.iKp;
    }

    public final boolean hasNext() {
        return this.iKs.hasNext();
    }

    public final void remove() {
    }
}
