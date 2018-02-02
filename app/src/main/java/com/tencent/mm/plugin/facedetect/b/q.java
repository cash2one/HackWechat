package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.protocal.c.bmr;
import com.tencent.mm.protocal.c.bms;
import com.tencent.mm.sdk.platformtools.x;

public final class q extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private e gJT;
    public boolean mfu = false;
    public boolean mfv = false;

    public q(int i) {
        a aVar = new a();
        aVar.hmj = new bmr();
        aVar.hmk = new bms();
        aVar.uri = "/cgi-bin/micromsg-bin/switchopface";
        aVar.hmi = 938;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        ((bmr) this.gJQ.hmg.hmo).vDW = i;
    }

    public final int getType() {
        return 938;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        bms com_tencent_mm_protocal_c_bms = (bms) ((b) qVar).hmh.hmo;
        this.mfu = com_tencent_mm_protocal_c_bms.wPT;
        this.mfv = com_tencent_mm_protocal_c_bms.wPU;
        x.i("MicroMsg.NetSceneFaceSwitchOpFace", "hy: NetSceneFaceSwitchOpFace errType: %d, errCode: %d, errMsg: %s, hasBio: %b, isOpen: %b", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, Boolean.valueOf(this.mfu), Boolean.valueOf(this.mfv)});
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
