package com.tencent.mm.plugin.talkroom.b;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiScanCode;
import com.tencent.mm.protocal.c.tb;
import com.tencent.mm.protocal.c.tc;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends k implements com.tencent.mm.network.k {
    private final com.tencent.mm.ae.b gJQ;
    private e gJT;
    private int sceneType;

    public b(int i, long j, String str, int i2) {
        this.sceneType = i2;
        a aVar = new a();
        aVar.hmj = new tb();
        aVar.hmk = new tc();
        aVar.uri = "/cgi-bin/micromsg-bin/exittalkroom";
        aVar.hmi = 333;
        aVar.hml = JsApiScanCode.CTRL_INDEX;
        aVar.hmm = 1000000148;
        this.gJQ = aVar.JZ();
        tb tbVar = (tb) this.gJQ.hmg.hmo;
        tbVar.wbg = str;
        tbVar.wbh = i;
        tbVar.wbi = j;
        tbVar.rYW = i2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.NetSceneExitTalkRoom", "doScene %d", new Object[]{Integer.valueOf(this.sceneType)});
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return 333;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneExitTalkRoom", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            this.gJT.a(i2, i3, str, this);
        } else {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
