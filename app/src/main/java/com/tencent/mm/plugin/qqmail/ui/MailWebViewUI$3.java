package com.tencent.mm.plugin.qqmail.ui;

import android.webkit.WebSettings.LayoutAlgorithm;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;
import com.tencent.xweb.p;

class MailWebViewUI$3 extends p {
    final /* synthetic */ MailWebViewUI ptN;

    MailWebViewUI$3(MailWebViewUI mailWebViewUI) {
        this.ptN = mailWebViewUI;
    }

    public final void blg() {
        MailWebViewUI.c(this.ptN).getSettings().setLayoutAlgorithm(LayoutAlgorithm.NORMAL);
    }

    public final boolean b(WebView webView, String str) {
        if (str.startsWith("weixin://private/getcontentwidth/")) {
            x.d("MicroMsg.QQMail.WebViewUI", "shouldOverride, url is getContentWidth scheme, url = " + str);
            MailWebViewUI.b(this.ptN, str);
        } else {
            webView.loadUrl(str);
        }
        return true;
    }

    public final void a(WebView webView, String str) {
        super.a(webView, str);
        s.a(webView, "weixin://private/getcontentwidth/", "document.getElementsByTagName('html')[0].scrollWidth;");
    }
}
