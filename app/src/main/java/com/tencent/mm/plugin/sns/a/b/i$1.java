package com.tencent.mm.plugin.sns.a.b;

import com.tencent.mm.bq.b;
import com.tencent.mm.protocal.c.ano;
import com.tencent.mm.sdk.platformtools.x;

class i$1 implements Runnable {
    final /* synthetic */ int qPI;
    final /* synthetic */ Object[] qPJ;
    final /* synthetic */ i qPK;

    i$1(i iVar, int i, Object[] objArr) {
        this.qPK = iVar;
        this.qPI = i;
        this.qPJ = objArr;
    }

    public final void run() {
        ano com_tencent_mm_protocal_c_ano = new ano();
        com_tencent_mm_protocal_c_ano.wuu = this.qPI;
        com_tencent_mm_protocal_c_ano.wuC = (int) (System.currentTimeMillis() / 1000);
        com_tencent_mm_protocal_c_ano.ksO = 1;
        String l = i.l(this.qPJ);
        com_tencent_mm_protocal_c_ano.wuv = new b(l.getBytes());
        i.a(this.qPK).vGC.add(com_tencent_mm_protocal_c_ano);
        x.i("MicroMsg.SnsLogMgr", "snsadlog " + this.qPI + " " + l);
        if (i.b(this.qPK) == 0) {
            i.a(this.qPK, System.currentTimeMillis());
        }
    }
}
