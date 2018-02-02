package com.tencent.mm.modelfriend;

import com.tencent.mm.ad.h;
import com.tencent.mm.ad.n;
import com.tencent.mm.protocal.c.aou;
import com.tencent.mm.protocal.c.aow;
import com.tencent.mm.sdk.platformtools.ag.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

class y$1 implements a {
    final /* synthetic */ aow hwC;
    final /* synthetic */ y hwD;

    y$1(y yVar, aow com_tencent_mm_protocal_c_aow) {
        this.hwD = yVar;
        this.hwC = com_tencent_mm_protocal_c_aow;
    }

    public final boolean JC() {
        return false;
    }

    public final boolean JB() {
        if (this.hwC != null && this.hwC.wvE.size() > 0) {
            Iterator it = this.hwC.wvE.iterator();
            while (it.hasNext()) {
                aou com_tencent_mm_protocal_c_aou = (aou) it.next();
                if (com_tencent_mm_protocal_c_aou.ktm == 1) {
                    h hVar = new h();
                    hVar.username = com_tencent_mm_protocal_c_aou.ksU;
                    hVar.hly = com_tencent_mm_protocal_c_aou.vUU;
                    hVar.hlx = com_tencent_mm_protocal_c_aou.vUV;
                    hVar.fDt = -1;
                    x.d("MicroMsg.NetSceneListMFriend", "getmlist  %s b[%s] s[%s]", new Object[]{hVar.getUsername(), hVar.JG(), hVar.JH()});
                    hVar.fWe = 3;
                    hVar.bA(true);
                    n.JQ().a(hVar);
                }
            }
        }
        return true;
    }

    public final String toString() {
        return super.toString() + "|onGYNetEnd";
    }
}
