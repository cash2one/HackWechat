package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.voip.b.a;

class l$1 implements e {
    final /* synthetic */ l snU;

    l$1(l lVar) {
        this.snU = lVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        a.eu("MicroMsg.NetSceneVoipStatReport", "onSceneEnd type:" + kVar.getType() + " errType:" + i + " errCode:" + i2);
    }
}
