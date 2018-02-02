package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bti;
import com.tencent.mm.protocal.c.btj;
import com.tencent.mm.protocal.c.but;

public final class b extends n<bti, btj> {
    String TAG = "MicroMsg.NetSceneVoipAnswer";

    public b(int i, int i2, int i3, byte[] bArr, byte[] bArr2, long j, boolean z, boolean z2) {
        a aVar = new a();
        aVar.hmj = new bti();
        aVar.hmk = new btj();
        aVar.uri = "/cgi-bin/micromsg-bin/voipanswer";
        aVar.hmi = 172;
        aVar.hml = 65;
        aVar.hmm = 1000000065;
        this.gJQ = aVar.JZ();
        bti com_tencent_mm_protocal_c_bti = (bti) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bti.wUz = i;
        com_tencent_mm_protocal_c_bti.wbh = i3;
        com_tencent_mm_protocal_c_bti.vWK = i2;
        but com_tencent_mm_protocal_c_but = new but();
        com_tencent_mm_protocal_c_but.ktN = 2;
        bdn com_tencent_mm_protocal_c_bdn = new bdn();
        com_tencent_mm_protocal_c_bdn.bj(bArr);
        com_tencent_mm_protocal_c_but.vKf = com_tencent_mm_protocal_c_bdn;
        com_tencent_mm_protocal_c_bti.wUm = com_tencent_mm_protocal_c_but;
        com_tencent_mm_protocal_c_but = new but();
        com_tencent_mm_protocal_c_but.ktN = 3;
        com_tencent_mm_protocal_c_bdn = new bdn();
        com_tencent_mm_protocal_c_bdn.bj(bArr2);
        com_tencent_mm_protocal_c_but.vKf = com_tencent_mm_protocal_c_bdn;
        com_tencent_mm_protocal_c_bti.wUn = com_tencent_mm_protocal_c_but;
        com_tencent_mm_protocal_c_bti.wbi = j;
        if (z2) {
            com_tencent_mm_protocal_c_bti.wUA = z ? 1 : 0;
        }
        com_tencent_mm_protocal_c_bti.wUq = System.currentTimeMillis();
    }

    public final int getType() {
        return 172;
    }

    public final e bHJ() {
        return new 1(this);
    }
}
