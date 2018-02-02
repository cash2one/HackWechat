package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.brz;
import com.tencent.mm.protocal.c.bsa;
import com.tencent.mm.sdk.platformtools.x;

public final class s extends k implements com.tencent.mm.network.k, e {
    private b gJQ;
    private e gJT;
    private boolean mfl = false;

    public s(long j, String str, String str2) {
        a aVar = new a();
        aVar.hmj = new brz();
        aVar.hmk = new bsa();
        aVar.uri = "/cgi-bin/micromsg-bin/verifyface";
        aVar.hmi = 797;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        brz com_tencent_mm_protocal_c_brz = (brz) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_brz.wiY = j;
        com_tencent_mm_protocal_c_brz.wIb = str;
        com_tencent_mm_protocal_c_brz.wIc = str2;
    }

    public final int getType() {
        return 797;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        bsa com_tencent_mm_protocal_c_bsa = (bsa) ((b) qVar).hmh.hmo;
        if (i2 == 0 && i3 == 0) {
            this.mfl = com_tencent_mm_protocal_c_bsa.wIe == 0;
            i3 = com_tencent_mm_protocal_c_bsa.wIe;
            x.i("MicroMsg.NetSceneFaceVerifyFace", "hy: is Verified: %b", new Object[]{Boolean.valueOf(this.mfl)});
        } else if (!(com_tencent_mm_protocal_c_bsa == null || com_tencent_mm_protocal_c_bsa.wIe == 0)) {
            x.i("MicroMsg.NetSceneFaceVerifyFace", "hy: has DetailRet, use it");
            i3 = com_tencent_mm_protocal_c_bsa.wIe;
        }
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final boolean aGh() {
        return true;
    }

    public final String aGi() {
        return null;
    }
}
