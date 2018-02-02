package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.sdk.platformtools.x;

class f$8 implements a {
    final /* synthetic */ f rog;
    final /* synthetic */ w rok;

    f$8(f fVar, w wVar) {
        this.rog = fVar;
        this.rok = wVar;
    }

    public final void bxc() {
    }

    public final void bxd() {
        x.e("AdLandingPagesPreDownloadResHelper", " pre download " + this.rok.rhn + "is error");
        f.a(this.rog, this.rok.rgD);
    }

    public final void KY(String str) {
        f.a(this.rog, this.rok.rhn);
    }
}
