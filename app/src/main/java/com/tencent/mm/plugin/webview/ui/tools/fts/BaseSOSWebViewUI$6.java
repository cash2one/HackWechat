package com.tencent.mm.plugin.webview.ui.tools.fts;

class BaseSOSWebViewUI$6 implements Runnable {
    final /* synthetic */ String jLQ;
    final /* synthetic */ int jLR;
    final /* synthetic */ int qSI;
    final /* synthetic */ BaseSOSWebViewUI tCm;

    BaseSOSWebViewUI$6(BaseSOSWebViewUI baseSOSWebViewUI, int i, String str, int i2) {
        this.tCm = baseSOSWebViewUI;
        this.qSI = i;
        this.jLQ = str;
        this.jLR = i2;
    }

    public final void run() {
        if (BaseSOSWebViewUI.x(this.tCm) != null) {
            BaseSOSWebViewUI.y(this.tCm).g(this.qSI, this.jLQ, this.jLR);
        }
    }
}
