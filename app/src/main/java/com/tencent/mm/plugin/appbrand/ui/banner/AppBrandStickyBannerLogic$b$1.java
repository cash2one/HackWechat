package com.tencent.mm.plugin.appbrand.ui.banner;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.b;

class AppBrandStickyBannerLogic$b$1 implements Runnable {
    final /* synthetic */ Intent val$intent;

    AppBrandStickyBannerLogic$b$1(Intent intent) {
        this.val$intent = intent;
    }

    public final void run() {
        if (b.x(this.val$intent)) {
            b.uc();
        }
    }
}
