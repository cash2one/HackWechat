package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.kn;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class SnsTimeLineUI$34 extends c<kn> {
    final /* synthetic */ SnsTimeLineUI rIN;

    SnsTimeLineUI$34(SnsTimeLineUI snsTimeLineUI) {
        this.rIN = snsTimeLineUI;
        this.xen = kn.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        SnsTimeLineUI.a(this.rIN).notifyDataSetChanged();
        return false;
    }
}
