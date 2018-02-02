package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.sdk.platformtools.x;

class b$2 implements a {
    final /* synthetic */ String jqI;
    final /* synthetic */ b rnf;

    b$2(b bVar, String str) {
        this.rnf = bVar;
        this.jqI = str;
    }

    public final void bxc() {
    }

    public final void bxd() {
        x.i("ContentFragment", "download img fail %s", new Object[]{this.jqI});
        b.c(this.rnf);
    }

    public final void KY(String str) {
        b.a(this.rnf, str, "adId", this.jqI);
    }
}
