package com.tencent.mm.plugin.webview.ui.tools.fts;

class BaseSOSWebViewUI$9 implements Runnable {
    final /* synthetic */ int hSk;
    final /* synthetic */ BaseSOSWebViewUI tCm;
    final /* synthetic */ String tCp;

    BaseSOSWebViewUI$9(BaseSOSWebViewUI baseSOSWebViewUI, String str, int i) {
        this.tCm = baseSOSWebViewUI;
        this.tCp = str;
        this.hSk = i;
    }

    public final void run() {
        if (BaseSOSWebViewUI.D(this.tCm) != null) {
            BaseSOSWebViewUI.E(this.tCm).cK(this.tCp, this.hSk);
        }
    }
}
