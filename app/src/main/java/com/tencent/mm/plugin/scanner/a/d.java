package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.hu;
import com.tencent.mm.protocal.c.hv;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends k implements com.tencent.mm.network.k {
    private String fqV;
    public b gJQ;
    private e gJT;
    private String lkP;
    private int scene;

    public d(String str, int i, String str2) {
        this.fqV = str;
        this.scene = i;
        this.lkP = str2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        a aVar = new a();
        aVar.hmj = new hu();
        aVar.hmk = new hv();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscangetproductinfo";
        aVar.hmi = 1063;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        hu huVar = (hu) this.gJQ.hmg.hmo;
        huVar.vIR = this.fqV;
        huVar.rYW = this.scene;
        huVar.vNN = this.lkP;
        return a(eVar, this.gJQ, this);
    }

    protected final int a(q qVar) {
        hu huVar = (hu) ((b) qVar).hmg.hmo;
        if (huVar.rYW >= 0 && huVar.vIR != null && huVar.vIR.length() > 0) {
            return k.b.hmP;
        }
        x.e("MicroMsg.scanner.NetSceneGetProductInfo", "ERR: Security Check Failed, Scene = %s", new Object[]{Integer.valueOf(huVar.rYW)});
        return k.b.hmQ;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.scanner.NetSceneGetProductInfo", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1063;
    }
}
