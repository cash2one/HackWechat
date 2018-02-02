package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.12;

class WebViewUI$12$42 implements Runnable {
    final /* synthetic */ String icx;
    final /* synthetic */ int irj;
    final /* synthetic */ 12 tAx;

    WebViewUI$12$42(12 12, String str, int i) {
        this.tAx = 12;
        this.icx = str;
        this.irj = i;
    }

    public final void run() {
        if (WebViewUI.r(this.tAx.tAv)) {
            if (this.icx != null) {
                this.tAx.tAv.setMMTitle(this.icx);
            }
            this.tAx.tAv.nR(this.irj);
        }
    }
}
