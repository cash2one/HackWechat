package com.tencent.mm.plugin.webview.ui.tools;

import android.view.KeyEvent;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter.a;

class WebViewUI$14 implements a {
    final /* synthetic */ WebViewUI tAv;

    WebViewUI$14(WebViewUI webViewUI) {
        this.tAv = webViewUI;
    }

    public final void aPu() {
        WebViewUI.c(this.tAv, 0);
        this.tAv.ptK.clearMatches();
        this.tAv.tyA.bUR();
    }

    public final void a(WebViewSearchContentInputFooter webViewSearchContentInputFooter) {
        if (webViewSearchContentInputFooter.getVisibility() == 0) {
            b(webViewSearchContentInputFooter);
        }
    }

    public final void aPv() {
        g.pQN.a(480, 5, 1, false);
        this.tAv.ptK.findNext(false);
    }

    public final void aPw() {
        g.pQN.a(480, 4, 1, false);
        this.tAv.ptK.findNext(true);
    }

    public final void b(WebViewSearchContentInputFooter webViewSearchContentInputFooter) {
        this.tAv.ptK.clearMatches();
        webViewSearchContentInputFooter.reset();
        this.tAv.tyA.o(0, 0, true);
        WebViewUI.c(this.tAv, false);
        this.tAv.ptK.findAllAsync(webViewSearchContentInputFooter.bUS());
    }

    public final boolean c(int i, KeyEvent keyEvent) {
        if (i == 67 && keyEvent.getAction() == 0) {
            g.pQN.a(480, 6, 1, false);
        }
        return false;
    }

    public final void onShow() {
    }
}
