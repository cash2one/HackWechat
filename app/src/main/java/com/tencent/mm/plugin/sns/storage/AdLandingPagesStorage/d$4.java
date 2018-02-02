package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad$a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class d$4 implements ad$a {
    final /* synthetic */ String rnS;
    final /* synthetic */ b rnV;
    final /* synthetic */ String rng;

    d$4(b bVar, String str, String str2) {
        this.rnV = bVar;
        this.rnS = str;
        this.rng = str2;
    }

    public final void cf(String str, int i) {
        ag.y(new 1(this, str, i));
    }

    public final void KZ(String str) {
        x.e("AdLandingPagesDownloadResourceHelper", " download error video for " + this.rnS + " for adid:" + this.rng);
        ag.y(new 2(this, str));
    }

    public final void La(String str) {
        x.i("AdLandingPagesDownloadResourceHelper", " download success video for " + this.rnS + " for adid:" + this.rng);
        ag.y(new 3(this, str));
    }
}
