package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.12;
import com.tencent.mm.sdk.platformtools.bh;

class WebViewUI$12$26 implements Runnable {
    final /* synthetic */ boolean jEm;
    final /* synthetic */ boolean tAP;
    final /* synthetic */ 12 tAx;

    WebViewUI$12$26(12 12, boolean z, boolean z2) {
        this.tAx = 12;
        this.tAP = z;
        this.jEm = z2;
    }

    public final void run() {
        if (this.tAP) {
            if (!(this.tAx.tAv.ptK == null || bh.ov(this.tAx.tAv.ptK.getUrl()))) {
                WebViewUI.e(this.tAx.tAv).put(this.tAx.tAv.ptK.getUrl(), Boolean.valueOf(false));
            }
            this.tAx.tAv.kt(false);
            return;
        }
        if (!(this.tAx.tAv.ptK == null || bh.ov(this.tAx.tAv.ptK.getUrl()))) {
            WebViewUI.e(this.tAx.tAv).put(this.tAx.tAv.ptK.getUrl(), Boolean.valueOf(this.jEm));
        }
        this.tAx.tAv.kt(this.jEm);
    }
}
