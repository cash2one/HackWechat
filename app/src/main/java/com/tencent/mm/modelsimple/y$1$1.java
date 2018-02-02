package com.tencent.mm.modelsimple;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelsimple.y.1;
import com.tencent.mm.sdk.platformtools.x;

class y$1$1 implements e {
    final /* synthetic */ 1 hNY;

    y$1$1(1 1) {
        this.hNY = 1;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.NetSceneReg", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 && i2 == 0) {
            this.hNY.hNX.a(this.hNY.hNX.hmA, this.hNY.hNX.gJT);
        } else {
            this.hNY.hNX.gJT.a(i, i2, "", this.hNY.hNX);
        }
    }
}
