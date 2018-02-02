package com.tencent.mm.plugin.webview.ui.tools.fts;

class FTSBaseWebViewUI$2 implements Runnable {
    final /* synthetic */ FTSBaseWebViewUI tCF;

    FTSBaseWebViewUI$2(FTSBaseWebViewUI fTSBaseWebViewUI) {
        this.tCF = fTSBaseWebViewUI;
    }

    public final void run() {
        if (FTSBaseWebViewUI.s(this.tCF) != null) {
            FTSBaseWebViewUI.t(this.tCF).a(this.tCF.bTC(), this.tCF.bTE(), this.tCF.bTF());
        }
    }
}
