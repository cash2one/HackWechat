package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.12;

class WebViewUI$12$44 implements Runnable {
    final /* synthetic */ Bundle fhp;
    final /* synthetic */ 12 tAx;

    WebViewUI$12$44(12 12, Bundle bundle) {
        this.tAx = 12;
        this.fhp = bundle;
    }

    public final void run() {
        boolean z = this.fhp.getBoolean("enable_fullscreen_params_enable", false);
        if (this.tAx.tAv.getIntent() != null) {
            this.tAx.tAv.getIntent().removeExtra("show_full_screen");
        }
        WebViewUI.b(this.tAx.tAv, z);
    }
}
