package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.sdk.platformtools.x;

class f$5 implements a {
    final /* synthetic */ f rog;
    final /* synthetic */ q roj;

    f$5(f fVar, q qVar) {
        this.rog = fVar;
        this.roj = qVar;
    }

    public final void bxc() {
    }

    public final void bxd() {
        x.e("AdLandingPagesPreDownloadResHelper", " pre download " + this.roj.rgB + "is error");
        f.a(this.rog, this.roj.rgB);
    }

    public final void KY(String str) {
        f.a(this.rog, this.roj.rgB);
    }
}
