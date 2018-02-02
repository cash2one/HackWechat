package com.tencent.mm.plugin.translate.a;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.agr;
import com.tencent.mm.protocal.c.ags;
import com.tencent.mm.protocal.c.bop;
import com.tencent.mm.protocal.c.boq;
import java.util.LinkedList;

public final class b extends k implements com.tencent.mm.network.k {
    private final com.tencent.mm.ae.b gJQ;
    private e gJT = null;
    public LinkedList<boq> sgb;

    public b(LinkedList<bop> linkedList) {
        a aVar = new a();
        aVar.hmj = new agr();
        aVar.hmk = new ags();
        aVar.uri = "/cgi-bin/micromsg-bin/gettranstext";
        aVar.hmi = 631;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        agr com_tencent_mm_protocal_c_agr = (agr) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_agr.woc = linkedList;
        com_tencent_mm_protocal_c_agr.ksN = linkedList.size();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return 631;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        ags com_tencent_mm_protocal_c_ags = (ags) this.gJQ.hmh.hmo;
        this.gJT.a(i2, i3, str, this);
        this.sgb = com_tencent_mm_protocal_c_ags.woc;
    }
}
