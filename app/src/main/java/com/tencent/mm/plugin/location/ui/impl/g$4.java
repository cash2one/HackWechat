package com.tencent.mm.plugin.location.ui.impl;

import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.plugin.location.model.f;
import com.tencent.mm.sdk.platformtools.x;

class g$4 implements a {
    final /* synthetic */ g nYb;

    g$4(g gVar) {
        this.nYb = gVar;
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        if (!z) {
            return false;
        }
        x.d("MicroMsg.ShareMapUI", "onGetLocation, latitude=%f, longtitude=%f, speed=%f", new Object[]{Float.valueOf(f2), Float.valueOf(f), Double.valueOf(d)});
        if (f.m(d) && !this.nYb.nXO.nVb) {
            x.d("MicroMsg.ShareMapUI", "set driving mode");
            this.nYb.nXO.nVe = false;
            this.nYb.nXO.gp(true);
            this.nYb.nXM.aVO();
        }
        return true;
    }
}
