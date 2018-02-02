package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.pt;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class SnsTimeLineUI$8 extends c<pt> {
    final /* synthetic */ SnsTimeLineUI rIN;

    SnsTimeLineUI$8(SnsTimeLineUI snsTimeLineUI) {
        this.rIN = snsTimeLineUI;
        this.xen = pt.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        pt ptVar = (pt) bVar;
        if (!(SnsTimeLineUI.g(this.rIN) == null || SnsTimeLineUI.g(this.rIN).rrt == null)) {
            com.tencent.mm.plugin.sns.h.b bVar2 = SnsTimeLineUI.g(this.rIN).rrt.qWT;
            bVar2.rcU.add(ptVar.fHw.fzW);
        }
        return false;
    }
}
