package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class d$1 implements b$a {
    final /* synthetic */ String icE;
    final /* synthetic */ d$a rnR;
    final /* synthetic */ String rnS;
    final /* synthetic */ String rng;

    d$1(d$a com_tencent_mm_plugin_sns_storage_AdLandingPagesStorage_d_a, String str, String str2, String str3) {
        this.rnR = com_tencent_mm_plugin_sns_storage_AdLandingPagesStorage_d_a;
        this.rnS = str;
        this.rng = str2;
        this.icE = str3;
    }

    public final void bxc() {
        ag.y(new 1(this));
    }

    public final void bxd() {
        x.e("AdLandingPagesDownloadResourceHelper", " download error img for " + this.rnS + " for adid:" + this.rng);
        ag.y(new 2(this));
    }

    public final void bxM() {
        x.i("AdLandingPagesDownloadResourceHelper", " download success img for " + this.rnS + " for adid:" + this.rng);
        ag.y(new 3(this));
    }
}
