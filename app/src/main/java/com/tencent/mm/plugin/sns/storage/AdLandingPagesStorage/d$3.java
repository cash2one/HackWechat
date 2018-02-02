package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.b.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class d$3 implements a {
    final /* synthetic */ String icE;
    final /* synthetic */ d.a rnR;
    final /* synthetic */ String rng;
    final /* synthetic */ String val$url;

    d$3(d.a aVar, String str, String str2, String str3) {
        this.rnR = aVar;
        this.val$url = str;
        this.rng = str2;
        this.icE = str3;
    }

    public final void bxc() {
        ag.y(new 1(this));
    }

    public final void bxd() {
        x.e("AdLandingPagesDownloadResourceHelper", " download error sight for " + this.val$url + " for adid:" + this.rng);
        ag.y(new Runnable(this) {
            final /* synthetic */ d$3 rnU;

            {
                this.rnU = r1;
            }

            public final void run() {
                this.rnU.rnR.bxd();
            }
        });
    }

    public final void bxM() {
        x.i("AdLandingPagesDownloadResourceHelper", " download success sight for " + this.val$url + " for adid:" + this.rng);
        ag.y(new 3(this));
    }
}
