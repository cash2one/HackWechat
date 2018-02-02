package com.tencent.mm.console;

import com.tencent.mm.network.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bd.a;

class b$1 implements a {
    final /* synthetic */ String gIk;
    final /* synthetic */ int gIl;

    b$1(String str, int i) {
        this.gIk = str;
        this.gIl = i;
    }

    public final void a(e eVar) {
        ar.CG().a(1, "", 0, false);
        x.cfk();
        ar.CG().a(2, this.gIk, this.gIl, ar.Hj());
    }
}
