package com.tencent.mm.plugin.webview.ui.tools.fts;

class FTSBaseWebViewUI$6 implements Runnable {
    final /* synthetic */ FTSBaseWebViewUI tCF;

    FTSBaseWebViewUI$6(FTSBaseWebViewUI fTSBaseWebViewUI) {
        this.tCF = fTSBaseWebViewUI;
    }

    public final void run() {
        if (FTSBaseWebViewUI.a(this.tCF) != null) {
            FTSBaseWebViewUI.b(this.tCF).a(this.tCF.bTC(), this.tCF.bTE(), this.tCF.bTF());
        }
    }
}
