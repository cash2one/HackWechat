package com.tencent.mm.plugin.report.b;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u.a;
import com.tencent.mm.plugin.report.b.d.1;
import com.tencent.mm.sdk.platformtools.x;

class d$1$1 implements a {
    final /* synthetic */ 1 pPW;

    d$1$1(1 1) {
        this.pPW = 1;
    }

    public final int a(int i, int i2, String str, b bVar, k kVar) {
        x.i("MicroMsg.MidHelper", "onGYNetEnd errType:%d errCode:%d msg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        return 0;
    }
}
