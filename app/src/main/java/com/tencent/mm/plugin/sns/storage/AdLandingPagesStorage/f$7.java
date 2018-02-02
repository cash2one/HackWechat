package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w;
import com.tencent.mm.sdk.platformtools.x;

class f$7 implements d$b {
    final /* synthetic */ f rog;
    final /* synthetic */ w rok;

    f$7(f fVar, w wVar) {
        this.rog = fVar;
        this.rok = wVar;
    }

    public final void KZ(String str) {
        x.e("AdLandingPagesPreDownloadResHelper", " pre download " + this.rok.rgD + "is error");
        f.a(this.rog, this.rok.rgD);
    }

    public final void La(String str) {
        f.a(this.rog, this.rok.rgD);
    }
}
