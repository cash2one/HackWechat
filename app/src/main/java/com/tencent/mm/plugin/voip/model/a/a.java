package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ae.e;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bte;
import com.tencent.mm.protocal.c.btf;
import com.tencent.mm.protocal.c.but;

public final class a extends n<bte, btf> {
    String TAG = "MicroMsg.NetSceneVoipAck";

    public a(int i, long j, int i2, byte[] bArr, byte[] bArr2, String str) {
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new bte();
        aVar.hmk = new btf();
        aVar.uri = "/cgi-bin/micromsg-bin/voipack";
        aVar.hmi = 305;
        aVar.hml = 123;
        aVar.hmm = 1000000123;
        this.gJQ = aVar.JZ();
        bte com_tencent_mm_protocal_c_bte = (bte) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bte.wbh = i;
        com_tencent_mm_protocal_c_bte.wbi = j;
        com_tencent_mm_protocal_c_bte.wUp = i2;
        if (i2 != 1) {
            com_tencent_mm_protocal_c_bte.wUl = 0;
            return;
        }
        com_tencent_mm_protocal_c_bte.wUo = str;
        but com_tencent_mm_protocal_c_but = new but();
        com_tencent_mm_protocal_c_but.ktN = 2;
        bdn com_tencent_mm_protocal_c_bdn = new bdn();
        com_tencent_mm_protocal_c_bdn.bj(bArr);
        com_tencent_mm_protocal_c_but.vKf = com_tencent_mm_protocal_c_bdn;
        com_tencent_mm_protocal_c_bte.wUm = com_tencent_mm_protocal_c_but;
        com_tencent_mm_protocal_c_but = new but();
        com_tencent_mm_protocal_c_but.ktN = 3;
        com_tencent_mm_protocal_c_bdn = new bdn();
        com_tencent_mm_protocal_c_bdn.bj(bArr2);
        com_tencent_mm_protocal_c_but.vKf = com_tencent_mm_protocal_c_bdn;
        com_tencent_mm_protocal_c_bte.wUn = com_tencent_mm_protocal_c_but;
        com_tencent_mm_protocal_c_bte.wUq = System.currentTimeMillis();
        com_tencent_mm_protocal_c_bte.wUl = 1;
    }

    public final int getType() {
        return 305;
    }

    public final e bHJ() {
        return new 1(this);
    }
}
