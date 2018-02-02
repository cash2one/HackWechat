package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.protocal.c.bth;
import com.tencent.mm.protocal.c.bur;
import com.tencent.mm.protocal.c.bus;
import com.tencent.mm.protocal.c.buu;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends n<bur, bus> {
    public h(int i, long j, int i2, int i3, int i4, int[] iArr) {
        int i5 = 0;
        a aVar = new a();
        aVar.hmj = new bur();
        aVar.hmk = new bus();
        aVar.uri = "/cgi-bin/micromsg-bin/voipRedirect";
        aVar.hmi = HardCoderJNI.IDKEY_HARDCODER_FEATURES;
        aVar.hml = 240;
        aVar.hmm = 1000000240;
        this.gJQ = aVar.JZ();
        bur com_tencent_mm_protocal_c_bur = (bur) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bur.wbh = i;
        com_tencent_mm_protocal_c_bur.wbi = j;
        com_tencent_mm_protocal_c_bur.wFB = i2;
        com_tencent_mm_protocal_c_bur.wWg = i3;
        com_tencent_mm_protocal_c_bur.wWh = i4;
        int i6 = 0;
        for (int i7 = 0; i7 < i4; i7++) {
            buu com_tencent_mm_protocal_c_buu = new buu();
            int i8 = i6 + 1;
            com_tencent_mm_protocal_c_buu.wWr = iArr[i6];
            i6 = i8 + 1;
            com_tencent_mm_protocal_c_buu.wWs = iArr[i8];
            i8 = i6 + 1;
            com_tencent_mm_protocal_c_buu.wWt = iArr[i6];
            int i9 = i8 + 1;
            com_tencent_mm_protocal_c_buu.wWu = iArr[i8];
            i6 = i9 + 1;
            com_tencent_mm_protocal_c_buu.wWv = iArr[i9];
            com_tencent_mm_protocal_c_bur.wWi.add(com_tencent_mm_protocal_c_buu);
        }
        if (this.skx.ske.spH.sls != 0) {
            i5 = (int) ((System.currentTimeMillis() - this.skx.ske.spH.sls) / 1000);
        }
        com_tencent_mm_protocal_c_bur.wWj = i5;
    }

    public final int getType() {
        return HardCoderJNI.IDKEY_HARDCODER_FEATURES;
    }

    public final void dP(int i, int i2) {
        if (i == 0 && i2 == 0) {
            if (((bus) this.gJQ.hmh.hmo) != null) {
                x.i("MicroMsg.Voip.Redirect", "roomId:%d, roomKey:%s, member:%d", new Object[]{Integer.valueOf(((bus) this.gJQ.hmh.hmo).wbh), Long.valueOf(((bus) this.gJQ.hmh.hmo).wbi), Integer.valueOf(((bus) this.gJQ.hmh.hmo).wFB)});
                return;
            }
            return;
        }
        x.i("MicroMsg.Voip.Redirect", "Redirect error");
    }

    public final e bHJ() {
        return new e(this) {
            final /* synthetic */ h snQ;

            {
                this.snQ = r1;
            }

            public final void a(int i, int i2, String str, k kVar) {
                com.tencent.mm.plugin.voip.b.a.et("MicroMsg.Voip.Redirect", "Redirect response:" + i + " errCode:" + i2 + " status:" + this.snQ.skx.mStatus);
                if (i2 != 0) {
                    com.tencent.mm.plugin.voip.b.a.es("MicroMsg.Voip.Redirect", " redirect response with error code:" + i2);
                    return;
                }
                bus com_tencent_mm_protocal_c_bus = (bus) this.snQ.bHN();
                com.tencent.mm.plugin.voip.b.a.et("MicroMsg.Voip.Redirect", "room " + com_tencent_mm_protocal_c_bus.wbh + " member " + com_tencent_mm_protocal_c_bus.wFB + " key " + com_tencent_mm_protocal_c_bus.wbi + " relay addr cnt " + com_tencent_mm_protocal_c_bus.wWk + " RedirectThreshold " + com_tencent_mm_protocal_c_bus.wWp + " RedirectDecision " + com_tencent_mm_protocal_c_bus.wWq);
                bth com_tencent_mm_protocal_c_bth = new bth();
                bth com_tencent_mm_protocal_c_bth2 = new bth();
                bth com_tencent_mm_protocal_c_bth3 = new bth();
                com_tencent_mm_protocal_c_bth.wUx = com_tencent_mm_protocal_c_bus.wWk;
                com_tencent_mm_protocal_c_bth.wUy = com_tencent_mm_protocal_c_bus.wWl;
                com_tencent_mm_protocal_c_bth2.wUx = com_tencent_mm_protocal_c_bus.wWm;
                com_tencent_mm_protocal_c_bth2.wUy = com_tencent_mm_protocal_c_bus.wWn;
                com_tencent_mm_protocal_c_bth3.wUx = com_tencent_mm_protocal_c_bus.wWo;
                com_tencent_mm_protocal_c_bth3.wUy = com_tencent_mm_protocal_c_bus.wVc;
                this.snQ.skx.ske.a(com_tencent_mm_protocal_c_bth, com_tencent_mm_protocal_c_bth2, com_tencent_mm_protocal_c_bth3, com_tencent_mm_protocal_c_bus.wWp, com_tencent_mm_protocal_c_bus.wWq);
            }
        };
    }
}
