package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.b;

class WebViewUI$13 implements b {
    final /* synthetic */ WebViewUI tAv;

    WebViewUI$13(WebViewUI webViewUI) {
        this.tAv = webViewUI;
    }

    public final void aPs() {
        WebViewUI.b(this.tAv, 0);
    }

    public final void aPt() {
        WebViewKeyboardLinearLayout webViewKeyboardLinearLayout = (WebViewKeyboardLinearLayout) this.tAv.findViewById(R.h.cYR);
        if (webViewKeyboardLinearLayout != null && webViewKeyboardLinearLayout.txF > 0) {
            WebViewUI.b(this.tAv, webViewKeyboardLinearLayout.txF);
        }
    }
}
