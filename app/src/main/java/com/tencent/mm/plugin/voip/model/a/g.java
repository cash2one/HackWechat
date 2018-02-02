package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.bum;
import com.tencent.mm.protocal.c.bun;
import com.tencent.mm.protocal.c.but;
import com.tencent.mm.z.q;
import java.util.LinkedList;
import java.util.List;

public final class g extends n<bum, bun> {
    public g(List<String> list, byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4) {
        a aVar = new a();
        aVar.hmj = new bum();
        aVar.hmk = new bun();
        aVar.uri = "/cgi-bin/micromsg-bin/voipinvite";
        aVar.hmi = 170;
        aVar.hml = 63;
        aVar.hmm = 1000000063;
        this.gJQ = aVar.JZ();
        bum com_tencent_mm_protocal_c_bum = (bum) this.gJQ.hmg.hmo;
        LinkedList linkedList = new LinkedList();
        for (int i5 = 0; i5 < list.size(); i5++) {
            linkedList.add(new bdo().UA((String) list.get(i5)));
        }
        com_tencent_mm_protocal_c_bum.wFM = q.FS();
        com_tencent_mm_protocal_c_bum.wVx = linkedList;
        com_tencent_mm_protocal_c_bum.wVw = linkedList.size();
        com_tencent_mm_protocal_c_bum.vWK = i;
        com_tencent_mm_protocal_c_bum.wOO = 0;
        com_tencent_mm_protocal_c_bum.wVl = i3;
        com_tencent_mm_protocal_c_bum.wFq = i4;
        but com_tencent_mm_protocal_c_but = new but();
        com_tencent_mm_protocal_c_but.ktN = 2;
        bdn com_tencent_mm_protocal_c_bdn = new bdn();
        com_tencent_mm_protocal_c_bdn.bj(bArr);
        com_tencent_mm_protocal_c_but.vKf = com_tencent_mm_protocal_c_bdn;
        com_tencent_mm_protocal_c_bum.wUm = com_tencent_mm_protocal_c_but;
        com_tencent_mm_protocal_c_but = new but();
        com_tencent_mm_protocal_c_but.ktN = 3;
        com_tencent_mm_protocal_c_bdn = new bdn();
        com_tencent_mm_protocal_c_bdn.bj(bArr2);
        com_tencent_mm_protocal_c_but.vKf = com_tencent_mm_protocal_c_bdn;
        com_tencent_mm_protocal_c_bum.wUn = com_tencent_mm_protocal_c_but;
        com_tencent_mm_protocal_c_bum.wUq = System.currentTimeMillis();
    }

    public final int getType() {
        return 170;
    }

    public final e bHJ() {
        return new 1(this);
    }
}
