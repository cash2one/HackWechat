package com.tencent.mm.plugin.webview.ui.tools.fts;

class BaseSOSWebViewUI$5 implements Runnable {
    final /* synthetic */ String jbV;
    final /* synthetic */ BaseSOSWebViewUI tCm;
    final /* synthetic */ int toa;

    BaseSOSWebViewUI$5(BaseSOSWebViewUI baseSOSWebViewUI, int i, String str) {
        this.tCm = baseSOSWebViewUI;
        this.toa = i;
        this.jbV = str;
    }

    public final void run() {
        if (BaseSOSWebViewUI.v(this.tCm) != null) {
            BaseSOSWebViewUI.w(this.tCm).aO(this.toa, this.jbV);
        }
    }
}
