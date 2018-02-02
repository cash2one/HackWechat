package com.tencent.mm.plugin.soter.d;

import com.tencent.d.b.a.b;
import com.tencent.d.b.a.d;
import com.tencent.d.b.a.e;
import com.tencent.mm.plugin.soter.c.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.g;

class a$1 implements b<d> {
    final /* synthetic */ a rSq;

    a$1(a aVar) {
        this.rSq = aVar;
    }

    public final /* synthetic */ void a(e eVar) {
        d dVar = (d) eVar;
        x.i("MicroMsg.SoterInitFunc", "alvinluo SoterInitFunc onResult errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(dVar.errCode), dVar.fnL});
        if (dVar.isSuccess()) {
            x.v("MicroMsg.SoterInitFunc", "alvinluo resume %d", new Object[]{Long.valueOf(System.currentTimeMillis())});
            a.a(this.rSq).resume();
            return;
        }
        a.dM(0, dVar.errCode);
        a.a(this.rSq).cl(g.u(Integer.valueOf(dVar.errCode), dVar.fnL));
    }
}
