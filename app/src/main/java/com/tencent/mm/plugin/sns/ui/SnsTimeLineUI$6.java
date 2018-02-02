package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.po;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class SnsTimeLineUI$6 extends c<po> {
    final /* synthetic */ SnsTimeLineUI rIN;

    SnsTimeLineUI$6(SnsTimeLineUI snsTimeLineUI) {
        this.rIN = snsTimeLineUI;
        this.xen = po.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        po poVar = (po) bVar;
        if (!(SnsTimeLineUI.g(this.rIN) == null || SnsTimeLineUI.g(this.rIN).rrt == null)) {
            SnsTimeLineUI.g(this.rIN).rrt.qWT.ef(poVar.fHr.frH, poVar.fHr.fzW);
        }
        return false;
    }
}
