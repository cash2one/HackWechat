package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.12;
import com.tencent.mm.sdk.platformtools.x;

class WebViewUI$12$24 implements Runnable {
    final /* synthetic */ int aar;
    final /* synthetic */ 12 tAx;

    WebViewUI$12$24(12 12, int i) {
        this.tAx = 12;
        this.aar = i;
    }

    public final void run() {
        this.tAx.tAv.setProgressBarIndeterminateVisibility(false);
        x.d("MicroMsg.WebViewUI", "[cpan] set title pb visibility:%d", new Object[]{Integer.valueOf(this.aar)});
        if (this.aar != 0) {
            this.tAx.tAv.tyo.finish();
        } else if (!WebViewUI.c(this.tAx.tAv) && !WebViewUI.d(this.tAx.tAv)) {
            this.tAx.tAv.tyo.start();
        }
    }
}
