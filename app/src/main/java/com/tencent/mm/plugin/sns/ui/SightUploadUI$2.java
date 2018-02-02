package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.pi;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.ui.widget.MMEditText.a;

class SightUploadUI$2 implements a {
    final /* synthetic */ SightUploadUI rxb;

    SightUploadUI$2(SightUploadUI sightUploadUI) {
        this.rxb = sightUploadUI;
    }

    public final void aXC() {
        this.rxb.aWs();
        b piVar = new pi();
        piVar.fHh.type = 0;
        piVar.fHh.fHj = false;
        com.tencent.mm.sdk.b.a.xef.m(piVar);
        this.rxb.finish();
    }
}
