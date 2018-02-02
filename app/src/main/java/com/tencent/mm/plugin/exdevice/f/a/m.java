package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bpk;
import com.tencent.mm.protocal.c.bpl;
import com.tencent.mm.sdk.platformtools.x;

public final class m extends k implements com.tencent.mm.network.k {
    private b gJQ = null;
    private e gJT = null;
    public String lOV;
    public String lOW;

    public m(String str, String str2) {
        this.lOV = str;
        this.lOW = str2;
        a aVar = new a();
        aVar.hmj = new bpk();
        aVar.hmk = new bpl();
        aVar.uri = "/cgi-bin/mmbiz-bin/rank/updatecover";
        aVar.hmi = 1040;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        bpk com_tencent_mm_protocal_c_bpk = (bpk) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bpk.woA = str;
        com_tencent_mm_protocal_c_bpk.lOW = str2;
    }

    public final int getType() {
        return 1040;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneUpdateRankCoverAndMotto", "hy: scene end. errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gJT.a(i2, i3, str, this);
    }
}
