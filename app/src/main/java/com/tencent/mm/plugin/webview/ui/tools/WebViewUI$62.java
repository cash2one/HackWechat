package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;

class WebViewUI$62 implements OnClickListener {
    final /* synthetic */ WebViewUI tAv;

    WebViewUI$62(WebViewUI webViewUI) {
        this.tAv = webViewUI;
    }

    public final void onClick(View view) {
        WebViewUI.aM(this.tAv).dismiss();
    }
}
