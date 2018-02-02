package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ajr;
import com.tencent.mm.protocal.c.bfj;
import com.tencent.mm.protocal.c.bfk;
import com.tencent.mm.sdk.platformtools.x;

public final class v extends k implements com.tencent.mm.network.k {
    public b gJQ = null;
    private e gJT = null;

    public v(String str, String str2, String str3) {
        a aVar = new a();
        aVar.hmj = new bfj();
        aVar.hmk = new bfk();
        aVar.uri = "/cgi-bin/mmoc-bin/hardware/searchwifiharddevice";
        aVar.hmi = 1270;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        bfj com_tencent_mm_protocal_c_bfj = (bfj) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bfj.vLR = new ajr();
        com_tencent_mm_protocal_c_bfj.vLR.vJA = str;
        com_tencent_mm_protocal_c_bfj.vLR.ksX = str2;
        com_tencent_mm_protocal_c_bfj.wKp = str3;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.exdevice.NetSceneSearchWiFiHardDevice", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1270;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
