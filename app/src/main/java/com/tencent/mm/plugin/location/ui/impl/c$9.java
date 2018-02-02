package com.tencent.mm.plugin.location.ui.impl;

import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.plugin.location.ui.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class c$9 implements a {
    final /* synthetic */ c nXi;

    c$9(c cVar) {
        this.nXi = cVar;
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        if (!z) {
            return false;
        }
        if (c.g(this.nXi) == -85.0d || c.h(this.nXi) == -1000.0d) {
            x.d("MicroMsg.MMPoiMapUI", "first get location");
            Object obj = ((int) (1000000.0f * f2)) + "," + ((int) (1000000.0f * f));
            ar.Hg();
            c.CU().a(w.a.USERINFO_LAST_LOCATION_STRING, obj);
            c.c(this.nXi, (double) f2);
            c.d(this.nXi, (double) f);
            c.a(this.nXi, f2);
            c.b(this.nXi, f);
            c.a(this.nXi, c.g(this.nXi));
            c.b(this.nXi, c.h(this.nXi));
            c.k(this.nXi).k(c.i(this.nXi), c.j(this.nXi));
            this.nXi.nTp.getIController().animateTo(c.g(this.nXi), c.h(this.nXi), d.gm(false));
            if (!c.q(this.nXi)) {
                c.m(this.nXi);
            }
        }
        return true;
    }
}
