package com.tencent.mm.plugin.webview.ui.tools;

import android.webkit.WebView.FindListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;

class WebViewUI$15 implements FindListener {
    final /* synthetic */ WebViewUI tAv;

    WebViewUI$15(WebViewUI webViewUI) {
        this.tAv = webViewUI;
    }

    public final void onFindResultReceived(int i, int i2, boolean z) {
        if (!(!z || WebViewUI.E(this.tAv) || bh.ov(this.tAv.tyA.bUS()))) {
            if (i2 == 0) {
                g.pQN.a(480, 3, 1, false);
            } else {
                g.pQN.a(480, 2, 1, false);
            }
            WebViewUI.c(this.tAv, true);
        }
        this.tAv.tyA.o(i, i2, z);
    }
}
