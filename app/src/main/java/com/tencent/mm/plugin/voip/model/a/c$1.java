package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.voip.b.a;

class c$1 implements e {
    final /* synthetic */ c snL;

    c$1(c cVar) {
        this.snL = cVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        a.eu("MicroMsg.NetSceneVoipCancelInvite", "onSceneEnd type:" + kVar.getType() + " errType:" + i + " errCode:" + i2);
    }
}
