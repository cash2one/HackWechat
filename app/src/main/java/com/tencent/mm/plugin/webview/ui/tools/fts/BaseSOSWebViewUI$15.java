package com.tencent.mm.plugin.webview.ui.tools.fts;

class BaseSOSWebViewUI$15 implements Runnable {
    final /* synthetic */ BaseSOSWebViewUI tCm;

    BaseSOSWebViewUI$15(BaseSOSWebViewUI baseSOSWebViewUI) {
        this.tCm = baseSOSWebViewUI;
    }

    public final void run() {
        if (BaseSOSWebViewUI.g(this.tCm) != null) {
            BaseSOSWebViewUI.h(this.tCm).b(this.tCm.bTC(), this.tCm.bTE(), this.tCm.bTF());
        }
    }
}
