package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.ql;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class SnsTimeLineUI$50 extends c<ql> {
    final /* synthetic */ SnsTimeLineUI rIN;

    SnsTimeLineUI$50(SnsTimeLineUI snsTimeLineUI) {
        this.rIN = snsTimeLineUI;
        this.xen = ql.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (SnsTimeLineUI.g(this.rIN) != null) {
            com.tencent.mm.plugin.sns.h.b bVar2 = SnsTimeLineUI.g(this.rIN).rrt.qWT;
            bVar2.rbz++;
            SnsTimeLineUI.g(this.rIN).rrt.qWT.ip(false);
        }
        return false;
    }
}
