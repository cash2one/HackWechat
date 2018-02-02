package com.tencent.mm.plugin.webview.ui.tools.fts;

class FTSBaseWebViewUI$11 implements Runnable {
    final /* synthetic */ String jbV;
    final /* synthetic */ FTSBaseWebViewUI tCF;
    final /* synthetic */ int toa;

    FTSBaseWebViewUI$11(FTSBaseWebViewUI fTSBaseWebViewUI, int i, String str) {
        this.tCF = fTSBaseWebViewUI;
        this.toa = i;
        this.jbV = str;
    }

    public final void run() {
        if (FTSBaseWebViewUI.o(this.tCF) != null) {
            FTSBaseWebViewUI.p(this.tCF).aO(this.toa, this.jbV);
        }
    }
}
