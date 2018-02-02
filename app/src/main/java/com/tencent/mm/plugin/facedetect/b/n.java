package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bbt;
import com.tencent.mm.protocal.c.bbu;
import com.tencent.mm.sdk.platformtools.x;

public final class n extends k implements com.tencent.mm.network.k, e {
    private b gJQ;
    private e gJT;
    private boolean mfl = false;
    private String mfp = null;

    public n(long j, String str, String str2) {
        a aVar = new a();
        aVar.hmj = new bbt();
        aVar.hmk = new bbu();
        aVar.uri = "/cgi-bin/micromsg-bin/registerface";
        aVar.hmi = 918;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        bbt com_tencent_mm_protocal_c_bbt = (bbt) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bbt.wiY = j;
        com_tencent_mm_protocal_c_bbt.wIb = str;
        com_tencent_mm_protocal_c_bbt.wIc = str2;
    }

    public final int getType() {
        return 918;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        bbu com_tencent_mm_protocal_c_bbu = (bbu) ((b) qVar).hmh.hmo;
        if (i2 == 0 && i3 == 0) {
            this.mfl = com_tencent_mm_protocal_c_bbu.wIe == 0;
            this.mfp = com_tencent_mm_protocal_c_bbu.wId;
            i3 = com_tencent_mm_protocal_c_bbu.wIe;
            x.i("MicroMsg.NetSceneFaceRegFace", "hy: is Verified: %b", new Object[]{Boolean.valueOf(this.mfl)});
        } else if (!(com_tencent_mm_protocal_c_bbu == null || com_tencent_mm_protocal_c_bbu.wIe == 0)) {
            x.i("MicroMsg.NetSceneFaceRegFace", "hy: has detail ret. use");
            i3 = com_tencent_mm_protocal_c_bbu.wIe;
        }
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final boolean aGh() {
        return true;
    }

    public final String aGi() {
        return this.mfp;
    }
}
