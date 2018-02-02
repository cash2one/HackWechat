package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.sdk.platformtools.ac;

class FreeWifiManufacturerLoadingUI$7 implements Runnable {
    final /* synthetic */ FreeWifiManufacturerLoadingUI mHX;
    final /* synthetic */ String mIb;

    FreeWifiManufacturerLoadingUI$7(FreeWifiManufacturerLoadingUI freeWifiManufacturerLoadingUI, String str) {
        this.mHX = freeWifiManufacturerLoadingUI;
        this.mIb = str;
    }

    public final void run() {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.mIb);
        intent.putExtra("show_bottom", false);
        intent.putExtra("allow_wx_schema_url", true);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("stastic_scene", 7);
        intent.putExtra("neverBlockLocalRequest", true);
        if (FreeWifiManufacturerLoadingUI.g(this.mHX)) {
            d.b(ac.getContext(), "webview", ".ui.tools.WebViewUI", intent);
        }
    }
}
