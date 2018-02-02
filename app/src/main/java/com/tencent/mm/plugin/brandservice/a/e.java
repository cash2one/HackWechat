package com.tencent.mm.plugin.brandservice.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aps;
import com.tencent.mm.protocal.c.apt;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends k implements com.tencent.mm.network.k {
    public b gJQ;
    private com.tencent.mm.ae.e gJT;

    public e(String str) {
        a aVar = new a();
        aVar.hmj = new aps();
        aVar.hmk = new apt();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/getallrecvtmpmsgoption";
        aVar.hmi = 1031;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        ((aps) this.gJQ.hmg.hmo).wrU = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.brandservice.NetSceneGetAllRecvTmpMsgOption", "onGYNetEnd code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1031;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ae.e eVar2) {
        this.gJT = eVar2;
        x.i("MicroMsg.brandservice.NetSceneGetAllRecvTmpMsgOption", "do scene");
        return a(eVar, this.gJQ, this);
    }
}
