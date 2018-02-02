package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.sdk.platformtools.x;

class f$9 implements a {
    final /* synthetic */ f rog;
    final /* synthetic */ String val$url;

    f$9(f fVar, String str) {
        this.rog = fVar;
        this.val$url = str;
    }

    public final void bxc() {
    }

    public final void bxd() {
        x.e("AdLandingPagesPreDownloadResHelper", " pre download " + this.val$url + "is error");
        f.a(this.rog, this.val$url);
    }

    public final void KY(String str) {
        f.a(this.rog, this.val$url);
    }
}
