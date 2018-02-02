package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;

class f$2 implements Runnable {
    final /* synthetic */ String rng;
    final /* synthetic */ f rog;
    final /* synthetic */ s roh;

    f$2(f fVar, String str, s sVar) {
        this.rog = fVar;
        this.rng = str;
        this.roh = sVar;
    }

    public final void run() {
        f.a(this.rog, this.rng, this.roh);
    }
}
