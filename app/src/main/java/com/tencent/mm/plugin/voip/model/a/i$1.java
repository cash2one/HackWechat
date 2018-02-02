package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.voip.b.a;

class i$1 implements e {
    final /* synthetic */ i snR;

    i$1(i iVar) {
        this.snR = iVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        a.eu(this.snR.TAG, "onSceneEnd type:" + kVar.getType() + " errType:" + i + " errCode:" + i2);
    }
}
