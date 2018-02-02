package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.pz;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class SnsTimeLineUI$2 extends c<pz> {
    final /* synthetic */ SnsTimeLineUI rIN;

    SnsTimeLineUI$2(SnsTimeLineUI snsTimeLineUI) {
        this.rIN = snsTimeLineUI;
        this.xen = pz.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        SnsTimeLineUI.a(this.rIN).rJv.notifyVendingDataChange();
        return false;
    }
}
