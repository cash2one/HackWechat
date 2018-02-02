package com.tencent.mm.plugin.webview.ui.tools.fts;

class FTSBaseWebViewUI$7 implements Runnable {
    final /* synthetic */ FTSBaseWebViewUI tCF;

    FTSBaseWebViewUI$7(FTSBaseWebViewUI fTSBaseWebViewUI) {
        this.tCF = fTSBaseWebViewUI;
    }

    public final void run() {
        if (FTSBaseWebViewUI.c(this.tCF) != null) {
            FTSBaseWebViewUI.d(this.tCF).a(this.tCF.bTC(), this.tCF.bTE(), this.tCF.bTF());
        }
    }
}
