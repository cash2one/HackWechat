package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.sdk.platformtools.x;

class f$3 implements a {
    final /* synthetic */ f rog;
    final /* synthetic */ o roi;

    f$3(f fVar, o oVar) {
        this.rog = fVar;
        this.roi = oVar;
    }

    public final void bxc() {
    }

    public final void bxd() {
        x.e("AdLandingPagesPreDownloadResHelper", " pre download " + this.roi.rgz + "is error");
        f.a(this.rog, this.roi.rgz);
    }

    public final void KY(String str) {
        f.a(this.rog, this.roi.rgz);
    }
}
