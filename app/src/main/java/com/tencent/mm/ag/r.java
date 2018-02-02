package com.tencent.mm.ag;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.zl;
import com.tencent.mm.protocal.c.zm;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;

public final class r extends k implements com.tencent.mm.network.k {
    Object data;
    public b gJQ;
    private e gJT;

    public r(String str, int i, Object obj) {
        a aVar = new a();
        aVar.hmj = new zl();
        aVar.hmk = new zm();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getbizenterpriseattr";
        aVar.hmi = 1343;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        zl zlVar = (zl) this.gJQ.hmg.hmo;
        zlVar.vNq = str;
        zlVar.wjf = i;
        zlVar.wjg = w.cfi().equals("zh_CN") ? 2 : 1;
        this.data = obj;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetBizEnterpriseAttr", "onGYNetEnd code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1343;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        x.i("MicroMsg.NetSceneGetBizEnterpriseAttr", "do scene");
        return a(eVar, this.gJQ, this);
    }
}
