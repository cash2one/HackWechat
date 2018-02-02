package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.modeltools.e.a;
import com.tencent.mm.plugin.webview.modeltools.e.b;
import com.tencent.mm.sdk.platformtools.x;

class WebViewUI$2 implements b {
    final /* synthetic */ WebViewUI tAv;

    WebViewUI$2(WebViewUI webViewUI) {
        this.tAv = webViewUI;
    }

    public final void a(a aVar, a aVar2) {
        x.i("MicroMsg.WebViewUI", "OrientationListener lastOrientation:" + aVar.name() + "; newOrientation:" + aVar2.name());
        this.tAv.screenOrientation = 4;
        this.tAv.afg();
        if (this.tAv.tyy != null) {
            this.tAv.tyy.disable();
        }
    }
}
