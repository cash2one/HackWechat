package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.widget.FontChooserView$a;
import com.tencent.mm.sdk.platformtools.x;

class WebViewUI$k implements FontChooserView$a {
    final /* synthetic */ WebViewUI tAv;

    private WebViewUI$k(WebViewUI webViewUI) {
        this.tAv = webViewUI;
    }

    public final void vS(int i) {
        int i2 = 2;
        switch (i) {
            case 0:
                i2 = 1;
                break;
            case 2:
                i2 = 3;
                break;
            case 3:
                i2 = 4;
                break;
        }
        WebViewUI.d(this.tAv, i2);
        try {
            if (this.tAv.juQ.aOD()) {
                this.tAv.juQ.el(16384, i2);
                this.tAv.juQ.el(16388, i2);
            }
        } catch (Exception e) {
            x.w("MicroMsg.WebViewUI", "onCheckedChanged, ex = " + e.getMessage());
        }
    }
}
