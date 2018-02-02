package com.tencent.mm.plugin.setting.modelsimple;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.xe;
import com.tencent.mm.protocal.c.xf;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private e gJT;

    public c(String str) {
        a aVar = new a();
        aVar.hmj = new xe();
        aVar.hmk = new xf();
        aVar.uri = "/cgi-bin/micromsg-bin/generalset";
        aVar.hmi = 177;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        xe xeVar = (xe) this.gJQ.hmg.hmo;
        xeVar.wak = 1;
        xeVar.whu = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.NetSceneGeneralSet", "doScene");
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return 177;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGeneralSet", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        this.gJT.a(i2, i3, str, this);
    }
}
