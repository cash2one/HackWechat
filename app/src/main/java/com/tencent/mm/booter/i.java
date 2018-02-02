package com.tencent.mm.booter;

import com.tencent.mm.protocal.c.anp;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bo;
import java.util.LinkedList;

public final class i {
    public static void run() {
        int i;
        LinkedList linkedList = new LinkedList();
        int a = bh.a((Integer) ar.He().get(19), 0);
        for (i = 0; i < a; i++) {
            anp com_tencent_mm_protocal_c_anp = new anp();
            com_tencent_mm_protocal_c_anp.pQj = 31;
            com_tencent_mm_protocal_c_anp.pQt = "0";
            linkedList.add(com_tencent_mm_protocal_c_anp);
        }
        a = bh.a((Integer) ar.He().get(20), 0);
        for (i = 0; i < a; i++) {
            com_tencent_mm_protocal_c_anp = new anp();
            com_tencent_mm_protocal_c_anp.pQj = 31;
            com_tencent_mm_protocal_c_anp.pQt = "1";
            linkedList.add(com_tencent_mm_protocal_c_anp);
        }
        if (linkedList.size() > 0) {
            bo.a(linkedList);
            ar.He().set(19, Integer.valueOf(0));
            ar.He().set(20, Integer.valueOf(0));
        }
    }
}
