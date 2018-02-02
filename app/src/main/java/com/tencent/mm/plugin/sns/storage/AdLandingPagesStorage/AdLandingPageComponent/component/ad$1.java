package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad.a;
import com.tencent.mm.sdk.platformtools.af;

class ad$1 implements a {
    final /* synthetic */ af kCy;
    final /* synthetic */ a rlU;
    final /* synthetic */ ad rlV;

    ad$1(ad adVar, af afVar, a aVar) {
        this.rlV = adVar;
        this.kCy = afVar;
        this.rlU = aVar;
    }

    public final void cf(String str, int i) {
        this.kCy.post(new 1(this, str, i));
    }

    public final void KZ(String str) {
        this.kCy.post(new 2(this, str));
    }

    public final void La(String str) {
        this.kCy.post(new 3(this, str));
    }
}
