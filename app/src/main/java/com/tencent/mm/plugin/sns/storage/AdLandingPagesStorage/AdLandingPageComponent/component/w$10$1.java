package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.w.10;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.sdk.platformtools.x;

class w$10$1 implements a {
    final /* synthetic */ 10 rlu;

    w$10$1(10 10) {
        this.rlu = 10;
    }

    public final void bxc() {
    }

    public final void bxd() {
        x.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "video download fail");
        w.a(this.rlu.rls, true);
    }

    public final void KY(String str) {
        x.v("MicroMsg.Sns.AdLandingPageSightVideoComponent", "video view height " + this.rlu.rls.contentView.getHeight() + ", player height " + w.a(this.rlu.rls).getHeight());
        w.a(this.rlu.rls, false);
        w.a(this.rlu.rls, str);
        if (this.rlu.rls.rkO.fvG) {
            w.a(this.rlu.rls).Au(str);
            w.m(this.rlu.rls);
        }
    }
}
