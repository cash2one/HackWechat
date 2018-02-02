package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.d;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends k implements com.tencent.mm.network.k {
    private com.tencent.mm.ae.e gJT;
    private b hNJ;
    private d igS;
    public com.tencent.mm.protocal.c.e igT;
    public int scene;

    public e(String str, int i, String str2) {
        a aVar = new a();
        aVar.hmj = new d();
        aVar.hmk = new com.tencent.mm.protocal.c.e();
        aVar.hmi = 1530;
        aVar.uri = "/cgi-bin/mmpay-bin/newaaclose";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.hNJ = aVar.JZ();
        this.igS = (d) this.hNJ.hmg.hmo;
        this.igS.vCX = str2;
        this.igS.vCW = str;
        this.igS.scene = i;
        this.scene = i;
        x.d("MicroMsg.NetSceneAAClose", "NetSceneAAClose, billNo: %s, scene: %s", new Object[]{this.igS.vCW, Integer.valueOf(i)});
    }

    public final int getType() {
        return 1530;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ae.e eVar2) {
        x.i("MicroMsg.NetSceneAAClose", "doScene");
        this.gJT = eVar2;
        return a(eVar, this.hNJ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneAAClose", "onGYNetEnd, errType: %s, errCode: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.igT = (com.tencent.mm.protocal.c.e) ((b) qVar).hmh.hmo;
        x.i("MicroMsg.NetSceneAAClose", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.igT.liH), this.igT.liI});
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
