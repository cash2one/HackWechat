package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.auk;
import com.tencent.mm.protocal.c.aul;
import com.tencent.mm.protocal.c.bsz;
import java.util.LinkedList;

public final class a extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private e gJT;

    public a(LinkedList<bsz> linkedList, int i) {
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new auk();
        aVar.hmk = new aul();
        aVar.uri = "/cgi-bin/micromsg-bin/opvoicereminder";
        aVar.hmi = 331;
        aVar.hml = 150;
        aVar.hmm = 1000000150;
        this.gJQ = aVar.JZ();
        auk com_tencent_mm_protocal_c_auk = (auk) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_auk.vDW = 1;
        com_tencent_mm_protocal_c_auk.wCp = linkedList;
        com_tencent_mm_protocal_c_auk.wCo = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return 331;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.gJT.a(i2, i3, str, this);
    }
}
