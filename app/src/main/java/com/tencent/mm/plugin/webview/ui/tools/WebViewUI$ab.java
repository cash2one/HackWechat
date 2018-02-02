package com.tencent.mm.plugin.webview.ui.tools;

import java.lang.ref.WeakReference;

final class WebViewUI$ab {
    final int id;
    final WeakReference<WebViewUI> rTl;

    public WebViewUI$ab(WebViewUI webViewUI) {
        this.rTl = new WeakReference(webViewUI);
        this.id = webViewUI.hashCode();
    }
}
