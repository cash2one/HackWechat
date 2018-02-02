package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.model.c.a;
import com.tencent.mm.plugin.exdevice.service.c;
import com.tencent.mm.sdk.platformtools.ac;

class d$1 implements a {
    final /* synthetic */ d lKJ;

    d$1(d dVar) {
        this.lKJ = dVar;
    }

    public final void aDR() {
        if (d.a(this.lKJ) == null) {
            d.a(this.lKJ, new c());
            d.a(this.lKJ).lQd = null;
        }
        d.a(this.lKJ).cx(ac.getContext());
    }
}
