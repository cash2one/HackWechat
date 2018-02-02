package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ajy;
import com.tencent.mm.protocal.c.ajz;
import com.tencent.mm.protocal.c.fe;
import com.tencent.mm.sdk.platformtools.x;

public final class s extends k implements com.tencent.mm.network.k {
    private e gOB = null;
    private String lLR = null;
    private b lNe = null;

    public s(String str, String str2, String str3, int i) {
        a aVar = new a();
        aVar.hmj = new ajy();
        aVar.hmk = new ajz();
        aVar.uri = "/cgi-bin/mmbiz-bin/device/subscribestatus";
        aVar.hmi = 1090;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.lNe = aVar.JZ();
        ajy com_tencent_mm_protocal_c_ajy = (ajy) this.lNe.hmg.hmo;
        com_tencent_mm_protocal_c_ajy.vLb = com.tencent.mm.bq.b.Tl(str2);
        com_tencent_mm_protocal_c_ajy.vKZ = com.tencent.mm.bq.b.Tl(str3);
        com_tencent_mm_protocal_c_ajy.nhx = i;
        this.lLR = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.exdevice.NetSceneHardDeviceStatusSubscribe", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        ad.aEk().zg(this.lLR);
        if (i2 == 0 && i3 == 0) {
            fe feVar = ((ajz) this.lNe.hmh.hmo).wJr;
            int i4 = feVar.vJU;
            if (feVar.vLc.wJG) {
                String str2 = feVar.vLc.wJF;
            }
            x.i("MicroMsg.exdevice.NetSceneHardDeviceStatusSubscribe", "HardDeviceStatusSubResponse: ret=" + i4 + ",msg=" + str);
        }
        this.gOB.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1090;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gOB = eVar2;
        return a(eVar, this.lNe, this);
    }
}
