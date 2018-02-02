package com.tencent.mm.plugin.webview.ui.tools.fts;

class BaseSOSWebViewUI$8 implements Runnable {
    final /* synthetic */ String jLQ;
    final /* synthetic */ BaseSOSWebViewUI tCm;

    BaseSOSWebViewUI$8(BaseSOSWebViewUI baseSOSWebViewUI, String str) {
        this.tCm = baseSOSWebViewUI;
        this.jLQ = str;
    }

    public final void run() {
        if (BaseSOSWebViewUI.B(this.tCm) != null) {
            BaseSOSWebViewUI.C(this.tCm).PD(this.jLQ);
        }
    }
}
