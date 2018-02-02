package com.tencent.mm.plugin.webwx.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.tp;
import com.tencent.mm.protocal.c.tq;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends k implements com.tencent.mm.network.k {
    private e gJT;
    final b hFi;

    public d(String str) {
        a aVar = new a();
        com.tencent.mm.bq.a tpVar = new tp();
        com.tencent.mm.bq.a tqVar = new tq();
        aVar.hmj = tpVar;
        aVar.hmk = tqVar;
        aVar.uri = "/cgi-bin/micromsg-bin/extdeviceloginconfirmget";
        aVar.hmi = 971;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.hFi = aVar.JZ();
        tpVar.wbx = str;
        x.d("MicroMsg.NetSceneExtDeviceLoginConfirmGet", "[oneliang][NetSceneExtDeviceLoginConfirmGet]loginUrl:%s", new Object[]{str});
    }

    public final int getType() {
        return 971;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hFi, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneExtDeviceLoginConfirmGet", "onGYNetEnd  errType:" + i2 + " errCode:" + i3 + " errMsg:" + str);
        this.gJT.a(i2, i3, str, this);
    }
}
