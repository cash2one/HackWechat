package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.12;

class WebViewUI$12$18 implements Runnable {
    final /* synthetic */ double hyn;
    final /* synthetic */ String tAH;
    final /* synthetic */ int tAI;
    final /* synthetic */ int tAJ;
    final /* synthetic */ double tAK;
    final /* synthetic */ float tAL;
    final /* synthetic */ 12 tAx;

    WebViewUI$12$18(12 12, String str, int i, int i2, double d, double d2, float f) {
        this.tAx = 12;
        this.tAH = str;
        this.tAI = i;
        this.tAJ = i2;
        this.hyn = d;
        this.tAK = d2;
        this.tAL = f;
    }

    public final void run() {
        if (this.tAx.tAv.tlx != null) {
            this.tAx.tAv.tlx.a(this.tAH, this.tAI, this.tAJ, this.hyn, this.tAK, this.tAL);
        }
    }
}
