package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.ps;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class SnsTimeLineUI$7 extends c<ps> {
    final /* synthetic */ SnsTimeLineUI rIN;

    SnsTimeLineUI$7(SnsTimeLineUI snsTimeLineUI) {
        this.rIN = snsTimeLineUI;
        this.xen = ps.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ps psVar = (ps) bVar;
        if (!(SnsTimeLineUI.g(this.rIN) == null || SnsTimeLineUI.g(this.rIN).rrt == null)) {
            com.tencent.mm.plugin.sns.h.b bVar2 = SnsTimeLineUI.g(this.rIN).rrt.qWT;
            bVar2.rcV.add(psVar.fHv.fzW);
        }
        return false;
    }
}
