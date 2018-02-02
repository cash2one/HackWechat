package com.tencent.mm.plugin.appbrand.ui.banner;

import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a;
import com.tencent.mm.sdk.platformtools.bh;

class AppBrandStickyBannerLogic$a$1 implements f {
    final /* synthetic */ String fgU;

    AppBrandStickyBannerLogic$a$1(String str) {
        this.fgU = str;
    }

    public final void ak(String str, int i) {
        if (bh.ov(str)) {
            if (Boolean.TRUE.equals(a.ali().get(this.fgU))) {
                a.alj().X(this.fgU, false);
            }
            a.ali().put(this.fgU, Boolean.valueOf(false));
        } else if (this.fgU.equals(str)) {
            a.ali().put(this.fgU, Boolean.valueOf(true));
            a.alj().X(this.fgU, true);
        } else {
            a.ali().put(this.fgU, Boolean.valueOf(false));
            a.alj().X(this.fgU, false);
        }
    }
}
