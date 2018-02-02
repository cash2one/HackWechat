package com.tencent.mm.plugin.webview.ui.tools.fts;

class BaseSOSWebViewUI$16 implements Runnable {
    final /* synthetic */ BaseSOSWebViewUI tCm;

    BaseSOSWebViewUI$16(BaseSOSWebViewUI baseSOSWebViewUI) {
        this.tCm = baseSOSWebViewUI;
    }

    public final void run() {
        if (BaseSOSWebViewUI.i(this.tCm) != null) {
            BaseSOSWebViewUI.j(this.tCm).b(this.tCm.bTC(), this.tCm.bTE(), this.tCm.bTF());
        }
    }
}
