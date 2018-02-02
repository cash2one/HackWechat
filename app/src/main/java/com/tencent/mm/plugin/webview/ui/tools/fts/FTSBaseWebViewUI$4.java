package com.tencent.mm.plugin.webview.ui.tools.fts;

class FTSBaseWebViewUI$4 implements Runnable {
    final /* synthetic */ int hSk;
    final /* synthetic */ FTSBaseWebViewUI tCF;
    final /* synthetic */ String tCp;

    FTSBaseWebViewUI$4(FTSBaseWebViewUI fTSBaseWebViewUI, String str, int i) {
        this.tCF = fTSBaseWebViewUI;
        this.tCp = str;
        this.hSk = i;
    }

    public final void run() {
        if (FTSBaseWebViewUI.w(this.tCF) != null) {
            FTSBaseWebViewUI.x(this.tCF).cK(this.tCp, this.hSk);
        }
    }
}
