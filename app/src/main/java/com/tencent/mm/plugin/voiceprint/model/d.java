package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ahm;
import com.tencent.mm.protocal.c.ahn;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;
    String sgB = "";
    int sgC = 0;
    String sgD = "";

    public d(int i, String str) {
        a aVar = new a();
        aVar.hmj = new ahm();
        aVar.hmk = new ahn();
        aVar.uri = "/cgi-bin/micromsg-bin/getvoiceprintresource";
        aVar.hmi = 611;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        ahm com_tencent_mm_protocal_c_ahm = (ahm) this.gJQ.hmg.hmo;
        x.i("MicroMsg.NetSceneGetVoicePrintResource", "sceneType %d %s", new Object[]{Integer.valueOf(i), str});
        com_tencent_mm_protocal_c_ahm.woZ = i;
        com_tencent_mm_protocal_c_ahm.wpa = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return 611;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetVoicePrintResource", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        ahn com_tencent_mm_protocal_c_ahn = (ahn) ((b) qVar).hmh.hmo;
        if (i2 == 0 || i3 == 0) {
            if (com_tencent_mm_protocal_c_ahn.wpb != null) {
                this.sgB = new String(com_tencent_mm_protocal_c_ahn.wpb.wJi.wJD.oz);
                this.sgC = com_tencent_mm_protocal_c_ahn.wpb.wIj;
                x.d("MicroMsg.NetSceneGetVoicePrintResource", "vertify resid %d mtext %s", new Object[]{Integer.valueOf(this.sgC), this.sgB});
            } else {
                x.e("MicroMsg.NetSceneGetVoicePrintResource", "resp ResourceData null ");
            }
            this.gJT.a(i2, i3, str, this);
            return;
        }
        this.gJT.a(i2, i3, str, this);
    }
}
