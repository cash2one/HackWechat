package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.mm.pluginsdk.ui.applet.i.a;
import com.tencent.mm.z.s;

class g$3 implements a {
    final /* synthetic */ g vnF;

    g$3(g gVar) {
        this.vnF = gVar;
    }

    public final void BY(int i) {
        int i2 = 1;
        if (this.vnF.rUx != null && this.vnF.vnx != null) {
            h hVar = this.vnF.vnx;
            int i3 = hVar.vnT ? (hVar.lbP || i != hVar.vnR + 2) ? 0 : 1 : (hVar.lbP || i != hVar.vnR + 1) ? 0 : 1;
            if (i3 == 0) {
                hVar = this.vnF.vnx;
                if (hVar.lbP || i != hVar.vnR) {
                    i3 = 0;
                } else {
                    i3 = 1;
                }
                if (i3 != 0) {
                    this.vnF.rUx.of(i);
                    return;
                }
                hVar = this.vnF.vnx;
                if (hVar.lbP || i != hVar.vnR + 1) {
                    i2 = 0;
                }
                if (i2 != 0) {
                    if (!this.vnF.vnx.vnT) {
                        return;
                    }
                    if (s.eV(this.vnF.username)) {
                        this.vnF.rUx.od(i);
                    } else {
                        this.vnF.vnx.BZ(0);
                    }
                } else if (this.vnF.vnx.lbP && this.vnF.vnx.Ca(i)) {
                    this.vnF.rUx.od(i);
                } else if (this.vnF.vnx.lbP && !this.vnF.vnx.Ca(i)) {
                    this.vnF.rUx.axM();
                } else if (!this.vnF.vnx.lbP && this.vnF.vnx.Ca(i)) {
                    this.vnF.rUx.oe(i);
                }
            }
        }
    }
}
