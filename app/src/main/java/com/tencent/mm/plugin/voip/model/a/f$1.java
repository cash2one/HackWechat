package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.voip.b.a;

class f$1 implements e {
    final /* synthetic */ f snO;

    f$1(f fVar) {
        this.snO = fVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i != 0 && i2 == 231) {
            a.es(this.snO.TAG, "Voip heartbeat Failed, type:" + kVar.getType() + " errType:" + i + " errCode:" + i2);
            this.snO.skx.ske.spH.skR = 111;
            this.snO.skx.ske.spH.skS = i2;
            this.snO.skx.ske.spH.slj = 2;
            this.snO.skx.p(1, -9004, "");
        }
    }
}
