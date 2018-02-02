package com.tencent.mm.bc;

import com.tencent.mm.protocal.c.asp;
import java.util.Comparator;

class d$1 implements Comparator<asp> {
    d$1() {
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        asp com_tencent_mm_protocal_c_asp = (asp) obj;
        asp com_tencent_mm_protocal_c_asp2 = (asp) obj2;
        if (com_tencent_mm_protocal_c_asp.wAg > com_tencent_mm_protocal_c_asp2.wAg) {
            return 1;
        }
        return com_tencent_mm_protocal_c_asp.wAg < com_tencent_mm_protocal_c_asp2.wAg ? -1 : 0;
    }
}
