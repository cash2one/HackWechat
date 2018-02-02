package com.tencent.mm.plugin.appbrand.page;

import android.webkit.JavascriptInterface;
import com.tencent.mm.sdk.platformtools.x;

class p$a {
    final /* synthetic */ p jEg;

    private p$a(p pVar) {
        this.jEg = pVar;
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final float getPixelRatio() {
        return this.jEg.mContext.getResources().getDisplayMetrics().density;
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final float getWidth() {
        x.i("MicroMsg.AppBrandPageView", "DeviceInfoForSDK.getWidth view-width %d", new Object[]{Integer.valueOf(this.jEg.getContentView().getWidth())});
        return ((float) this.jEg.mContext.getResources().getDisplayMetrics().widthPixels) / getPixelRatio();
    }
}
