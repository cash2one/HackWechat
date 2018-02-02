package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.pu;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class SnsTimeLineUI$9 extends c<pu> {
    final /* synthetic */ SnsTimeLineUI rIN;

    SnsTimeLineUI$9(SnsTimeLineUI snsTimeLineUI) {
        this.rIN = snsTimeLineUI;
        this.xen = pu.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        pu puVar = (pu) bVar;
        if (!(SnsTimeLineUI.g(this.rIN) == null || SnsTimeLineUI.g(this.rIN).rrt == null)) {
            com.tencent.mm.plugin.sns.h.b bVar2 = SnsTimeLineUI.g(this.rIN).rrt.qWT;
            bVar2.rcR.add(puVar.fHx.fzW);
        }
        return false;
    }
}
