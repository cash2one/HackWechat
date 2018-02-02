package com.tencent.mm.ag.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.pk;
import com.tencent.mm.protocal.c.pl;
import com.tencent.mm.protocal.c.wj;
import com.tencent.mm.sdk.platformtools.x;

public final class n extends k implements com.tencent.mm.network.k {
    Object data;
    public b gJQ;
    private e gJT;

    public n(String str, wj wjVar, Object obj) {
        a aVar = new a();
        aVar.hmj = new pk();
        aVar.hmk = new pl();
        aVar.uri = "/cgi-bin/mmocbiz-bin/createbizchatinfo";
        aVar.hmi = 1355;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        pk pkVar = (pk) this.gJQ.hmg.hmo;
        pkVar.vNq = str;
        pkVar.vYt = wjVar;
        this.data = obj;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.brandservice.NetSceneCreateBizChatInfo", "onGYNetEnd code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1355;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        x.i("MicroMsg.brandservice.NetSceneCreateBizChatInfo", "do scene");
        return a(eVar, this.gJQ, this);
    }

    public final pl Mz() {
        if (this.gJQ == null || this.gJQ.hmh.hmo == null) {
            return null;
        }
        return (pl) this.gJQ.hmh.hmo;
    }

    public final pk MA() {
        if (this.gJQ == null || this.gJQ.hmg.hmo == null) {
            return null;
        }
        return (pk) this.gJQ.hmg.hmo;
    }
}
