package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.mm.plugin.webview.ui.tools.fts.a.a;

class FTSSOSHomeWebViewUI$4 implements a {
    final /* synthetic */ FTSSOSHomeWebViewUI tDo;

    FTSSOSHomeWebViewUI$4(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        this.tDo = fTSSOSHomeWebViewUI;
    }

    public final void onAnimationEnd() {
        FTSSOSHomeWebViewUI.a(this.tDo).Dh(3);
        FTSSOSHomeWebViewUI.v(this.tDo);
    }

    public final void onAnimationStart() {
        FTSSOSHomeWebViewUI.w(this.tDo);
    }
}
