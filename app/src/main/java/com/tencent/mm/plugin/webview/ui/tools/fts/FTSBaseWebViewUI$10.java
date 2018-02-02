package com.tencent.mm.plugin.webview.ui.tools.fts;

class FTSBaseWebViewUI$10 implements Runnable {
    final /* synthetic */ String jLQ;
    final /* synthetic */ FTSBaseWebViewUI tCF;
    final /* synthetic */ boolean tCo;
    final /* synthetic */ String tnb;

    FTSBaseWebViewUI$10(FTSBaseWebViewUI fTSBaseWebViewUI, String str, boolean z, String str2) {
        this.tCF = fTSBaseWebViewUI;
        this.jLQ = str;
        this.tCo = z;
        this.tnb = str2;
    }

    public final void run() {
        if (FTSBaseWebViewUI.m(this.tCF) != null) {
            FTSBaseWebViewUI.n(this.tCF).b(this.jLQ, this.tCo, this.tnb);
        }
    }
}
