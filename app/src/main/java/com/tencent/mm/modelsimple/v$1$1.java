package com.tencent.mm.modelsimple;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelsimple.v.1;
import com.tencent.mm.sdk.platformtools.x;

class v$1$1 implements e {
    final /* synthetic */ 1 hNF;

    v$1$1(1 1) {
        this.hNF = 1;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.NetSceneManualAuth", "summerauth dkcert getcert type:%d ret [%d,%d]", Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0 && i2 == 0) {
            this.hNF.hNE.a(this.hNF.hNE.hmA, this.hNF.hNE.gJT);
        } else {
            this.hNF.hNE.gJT.a(i, i2, "", this.hNF.hNE);
        }
    }
}
