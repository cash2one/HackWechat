package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.akl;
import com.tencent.mm.protocal.c.bok;
import com.tencent.mm.protocal.c.bol;
import com.tencent.mm.sdk.platformtools.x;

public final class n extends k implements com.tencent.mm.network.k {
    public String ffq = null;
    b gJQ = null;
    private e gJT = null;
    public int lNc = 0;

    public n(akl com_tencent_mm_protocal_c_akl, String str, String str2, int i) {
        a aVar = new a();
        aVar.hmj = new bok();
        aVar.hmk = new bol();
        aVar.uri = "/cgi-bin/mmoc-bin/hardware/transfermsgtodevice";
        aVar.hmi = 1717;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        bok com_tencent_mm_protocal_c_bok = (bok) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bok.vJA = str;
        com_tencent_mm_protocal_c_bok.vXI = str2;
        com_tencent_mm_protocal_c_bok.wQR = com_tencent_mm_protocal_c_akl;
        com_tencent_mm_protocal_c_bok.wQS = i;
        this.ffq = str2;
        this.lNc = i;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.exdevice.NetSceneGetAppMsgInfo", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1717;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
