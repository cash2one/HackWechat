package com.tencent.mm.plugin.order.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.protocal.c.sx;
import com.tencent.mm.protocal.c.sy;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.l;

public final class f extends l {
    private b gJQ;
    private e gJT;

    public f(String str, String str2, int i) {
        a aVar = new a();
        aVar.hmj = new sx();
        aVar.hmk = new sy();
        aVar.uri = "/cgi-bin/micromsg-bin/evaluateorder";
        aVar.hmi = 583;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        sx sxVar = (sx) this.gJQ.hmg.hmo;
        sxVar.wbn = str;
        sxVar.ngo = str2;
        sxVar.pQk = i;
        sxVar.vQS = i.bLf();
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.d("MicroMsg.NetSceneEvaluateOrder", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        this.gJT.a(i, i2, str, this);
    }

    public final int getType() {
        return 583;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
