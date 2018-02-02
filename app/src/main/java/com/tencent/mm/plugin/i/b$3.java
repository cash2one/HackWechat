package com.tencent.mm.plugin.i;

import com.tencent.mm.g.a.bl;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class b$3 extends c<bl> {
    final /* synthetic */ b kHR;

    b$3(b bVar) {
        this.kHR = bVar;
        this.xen = bl.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        return asO();
    }

    private boolean asO() {
        x.i("MicroMsg.CalcWxService", "%s clean wx file index event ", new Object[]{this.kHR.asN()});
        b.d(this.kHR, true);
        try {
            g.Dm().F(new 1(this));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CalcWxService", e, "%s clean wx file error", new Object[]{this.kHR.asN()});
        }
        return false;
    }
}
