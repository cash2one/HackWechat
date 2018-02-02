package com.tencent.mm.modelfriend;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelfriend.x.1;
import com.tencent.mm.sdk.platformtools.x;

class x$1$1 implements e {
    final /* synthetic */ 1 hwz;

    x$1$1(1 1) {
        this.hwz = 1;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.NetSceneGetSuggestAlias", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 && i2 == 0) {
            this.hwz.hwy.a(this.hwz.hwy.hmA, this.hwz.hwy.gJT);
        } else {
            this.hwz.hwy.gJT.a(i, i2, "", this.hwz.hwy);
        }
    }
}
