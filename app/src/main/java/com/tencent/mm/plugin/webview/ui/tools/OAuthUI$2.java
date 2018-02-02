package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.xweb.WebView;
import com.tencent.xweb.j;

class OAuthUI$2 extends j {
    final /* synthetic */ OAuthUI twM;

    OAuthUI$2(OAuthUI oAuthUI) {
        this.twM = oAuthUI;
    }

    public final void d(WebView webView, String str) {
        super.d(webView, str);
        this.twM.setMMTitle(str);
    }
}
