package com.tencent.mm.plugin.webview.ui.tools.fts;

class FTSBaseWebViewUI$3 implements Runnable {
    final /* synthetic */ String jLQ;
    final /* synthetic */ FTSBaseWebViewUI tCF;

    FTSBaseWebViewUI$3(FTSBaseWebViewUI fTSBaseWebViewUI, String str) {
        this.tCF = fTSBaseWebViewUI;
        this.jLQ = str;
    }

    public final void run() {
        if (FTSBaseWebViewUI.u(this.tCF) != null) {
            FTSBaseWebViewUI.v(this.tCF).PD(this.jLQ);
        }
    }
}
