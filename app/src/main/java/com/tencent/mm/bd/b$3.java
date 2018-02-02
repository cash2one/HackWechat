package com.tencent.mm.bd;

import com.tencent.mm.g.a.e;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class b$3 extends c<e> {
    final /* synthetic */ b hLN;

    b$3(b bVar) {
        this.hLN = bVar;
        this.xen = e.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (!((e) bVar).fmQ.fmR) {
            x.i("MicroMsg.SenseWhereHelper", "it is [deactivated mode], stop sense where sdk after %d", new Object[]{Integer.valueOf(Math.max(this.hLN.hLu, this.hLN.hLt))});
            b.Rr();
            b.a(this.hLN, r0);
        }
        return false;
    }
}
