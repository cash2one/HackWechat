package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.mm.protocal.c.bvn;
import java.util.Comparator;

class k$1 implements Comparator<bvn> {
    final /* synthetic */ k iQV;

    k$1(k kVar) {
        this.iQV = kVar;
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        bvn com_tencent_mm_protocal_c_bvn = (bvn) obj;
        bvn com_tencent_mm_protocal_c_bvn2 = (bvn) obj2;
        return (com_tencent_mm_protocal_c_bvn == null || com_tencent_mm_protocal_c_bvn2 == null) ? 0 : com_tencent_mm_protocal_c_bvn.hOH - com_tencent_mm_protocal_c_bvn2.hOH;
    }
}
