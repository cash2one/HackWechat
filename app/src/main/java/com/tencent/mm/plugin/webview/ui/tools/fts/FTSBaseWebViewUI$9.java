package com.tencent.mm.plugin.webview.ui.tools.fts;

import java.util.Map;

class FTSBaseWebViewUI$9 implements Runnable {
    final /* synthetic */ Map sPE;
    final /* synthetic */ FTSBaseWebViewUI tCF;

    FTSBaseWebViewUI$9(FTSBaseWebViewUI fTSBaseWebViewUI, Map map) {
        this.tCF = fTSBaseWebViewUI;
        this.sPE = map;
    }

    public final void run() {
        if (FTSBaseWebViewUI.k(this.tCF) != null) {
            FTSBaseWebViewUI.l(this.tCF).ao(this.sPE);
        }
    }
}
