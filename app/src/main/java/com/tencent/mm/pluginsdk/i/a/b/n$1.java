package com.tencent.mm.pluginsdk.i.a.b;

import com.tencent.mm.protocal.c.bcy;
import com.tencent.mm.protocal.c.bdd;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.List;

class n$1 implements Runnable {
    final /* synthetic */ List vhq;
    final /* synthetic */ n vhr;

    n$1(n nVar, List list) {
        this.vhr = nVar;
        this.vhq = list;
    }

    public final void run() {
        for (bdd com_tencent_mm_protocal_c_bdd : this.vhq) {
            String tag = this.vhr.getTag();
            String str = "resType(%d) responses.size() = %s";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(com_tencent_mm_protocal_c_bdd.ktN);
            objArr[1] = bh.cA(com_tencent_mm_protocal_c_bdd.wJp) ? "null" : String.valueOf(com_tencent_mm_protocal_c_bdd.wJp.size());
            x.i(tag, str, objArr);
            if (!bh.cA(com_tencent_mm_protocal_c_bdd.wJp)) {
                Iterator it = com_tencent_mm_protocal_c_bdd.wJp.iterator();
                while (it.hasNext()) {
                    n.a(this.vhr, com_tencent_mm_protocal_c_bdd.ktN, (bcy) it.next());
                }
            }
        }
    }
}
