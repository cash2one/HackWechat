package com.tencent.mm.plugin.wear.model.d;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ajw;
import com.tencent.mm.protocal.c.ajx;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends k implements com.tencent.mm.network.k {
    public String ffq;
    public String frg;
    private e gJT;
    private b hFi;

    public a(String str, String str2) {
        this.ffq = str;
        this.frg = str2;
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.uri = "/cgi-bin/mmbiz-bin/device/register";
        aVar.hmj = new ajw();
        aVar.hmk = new ajx();
        aVar.hml = 0;
        aVar.hmm = 0;
        this.hFi = aVar.JZ();
        ajw com_tencent_mm_protocal_c_ajw = (ajw) this.hFi.hmg.hmo;
        com_tencent_mm_protocal_c_ajw.vKZ = new com.tencent.mm.bq.b(str.getBytes());
        com_tencent_mm_protocal_c_ajw.vLb = new com.tencent.mm.bq.b(str2.getBytes());
        com_tencent_mm_protocal_c_ajw.wrc = new com.tencent.mm.bq.b("5".getBytes());
    }

    public final int getType() {
        return 1091;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hFi, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.Wear.NetSceneBizDeviceAuth", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        this.gJT.a(i2, i3, str, this);
    }
}
