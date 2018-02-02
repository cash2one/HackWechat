package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.text.Html;
import com.tencent.mm.sdk.platformtools.ag;

class z$1 implements Runnable {
    final /* synthetic */ String rly;
    final /* synthetic */ z rlz;

    z$1(z zVar, String str) {
        this.rlz = zVar;
        this.rly = str;
    }

    public final void run() {
        ag.y(new 2(this, Html.fromHtml(this.rly, new 1(this), null)));
    }
}
