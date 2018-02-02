package com.tencent.mm.plugin.location.ui.impl;

import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.sdk.platformtools.x;

class i$4 implements a {
    final /* synthetic */ i nYD;

    i$4(i iVar) {
        this.nYD = iVar;
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        if (!z) {
            return false;
        }
        x.d("MicroMsg.ViewMapUI", "onGetLocation flong " + f + " flat " + f2);
        if (((double) f2) == 0.0d && ((double) f) == 0.0d) {
            return true;
        }
        x.d("MicroMsg.ViewMapUI", "myLocation " + this.nYD.nVT.nQx + " " + this.nYD.nVT.nQy);
        if (!this.nYD.nVT.aVk()) {
            x.d("MicroMsg.ViewMapUI", "location my show");
            this.nYD.nVT.nQx = (double) f2;
            this.nYD.nVT.nQy = (double) f;
            this.nYD.nVX.a(this.nYD.nVT.nQx, this.nYD.nVT.nQy, this.nYD.nWe, this.nYD.nVT.nQw);
        }
        return true;
    }
}
