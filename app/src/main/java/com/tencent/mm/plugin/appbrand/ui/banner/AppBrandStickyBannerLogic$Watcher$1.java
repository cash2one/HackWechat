package com.tencent.mm.plugin.appbrand.ui.banner;

import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.Watcher;

class AppBrandStickyBannerLogic$Watcher$1 implements f {
    final /* synthetic */ Watcher jOE;

    AppBrandStickyBannerLogic$Watcher$1(Watcher watcher) {
        this.jOE = watcher;
    }

    public final void ak(String str, int i) {
        this.jOE.jOB = str;
        this.jOE.jOC = i;
        Watcher.a(this.jOE);
    }
}
