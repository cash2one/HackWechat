package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;

class WebViewUI$54 implements OnClickListener {
    final /* synthetic */ WebViewUI tAv;

    WebViewUI$54(WebViewUI webViewUI) {
        this.tAv = webViewUI;
    }

    public final void onClick(View view) {
        if (this.tAv.ptK != null) {
            this.tAv.ptK.goBack();
            WebViewUI.av(this.tAv);
        }
    }
}
