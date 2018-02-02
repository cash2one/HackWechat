package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bpm;
import com.tencent.mm.protocal.c.bpn;
import com.tencent.mm.sdk.platformtools.x;

public final class n extends k implements com.tencent.mm.network.k {
    private b gJQ = null;
    private e gJT = null;
    public int lPA;
    public int lPB;
    public int opType;

    public n(int i, int i2) {
        this.opType = i;
        this.lPA = i2;
        a aVar = new a();
        aVar.hmj = new bpm();
        aVar.hmk = new bpn();
        aVar.uri = "/cgi-bin/mmbiz-bin/rank/updateranksetting";
        aVar.hmi = 1044;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        bpm com_tencent_mm_protocal_c_bpm = (bpm) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bpm.fFn = this.opType;
        com_tencent_mm_protocal_c_bpm.fDt = this.lPA;
    }

    public final int getType() {
        return 1044;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneUpdateRankSetting", "hy: scene end. errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.lPB = ((bpn) this.gJQ.hmh.hmo).fDt;
        }
        this.gJT.a(i2, i3, str, this);
    }
}
