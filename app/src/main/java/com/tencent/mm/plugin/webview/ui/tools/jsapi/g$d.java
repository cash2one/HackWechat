package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.pluginsdk.model.app.g.a;

class g$d implements a {
    volatile boolean fze;
    volatile boolean hns;
    volatile boolean jdp;
    volatile boolean jdq;
    a tJD;

    g$d(a aVar) {
        this.tJD = aVar;
    }

    public final void cG(boolean z) {
        this.hns = true;
        this.jdp = z;
        if (this.jdq && this.tJD != null) {
            this.tJD.n(this.fze, z);
        }
    }

    final void cH(boolean z) {
        this.fze = z;
        this.jdq = true;
        if (this.hns && this.tJD != null) {
            this.tJD.n(z, this.jdp);
        }
    }
}
