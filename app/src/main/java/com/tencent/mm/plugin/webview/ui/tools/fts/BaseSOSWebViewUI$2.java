package com.tencent.mm.plugin.webview.ui.tools.fts;

import java.util.Map;

class BaseSOSWebViewUI$2 implements Runnable {
    final /* synthetic */ Map sPE;
    final /* synthetic */ BaseSOSWebViewUI tCm;

    BaseSOSWebViewUI$2(BaseSOSWebViewUI baseSOSWebViewUI, Map map) {
        this.tCm = baseSOSWebViewUI;
        this.sPE = map;
    }

    public final void run() {
        if (BaseSOSWebViewUI.o(this.tCm) != null) {
            BaseSOSWebViewUI.p(this.tCm).ao(this.sPE);
        }
    }
}
