package com.tencent.mm.plugin.shake.c.a;

import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.sdk.platformtools.x;

class g$1 implements a {
    final /* synthetic */ g qoJ;

    g$1(g gVar) {
        this.qoJ = gVar;
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        if (!z) {
            return true;
        }
        if (g.a(this.qoJ) == -85.0f && g.b(this.qoJ) == -1000.0f) {
            g.a(this.qoJ, f2);
            g.b(this.qoJ, f);
            m.brI().gyz = g.a(this.qoJ);
            m.brI().gyA = g.b(this.qoJ);
            if (g.c(this.qoJ)) {
                x.i("MicroMsg.ShakeCardService", "ShakeCardService do netscen from onGetLocation()");
                g.d(this.qoJ);
            }
        }
        return false;
    }
}
