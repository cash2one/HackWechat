package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.a;

class FTSSOSHomeWebViewUI$a$4 implements Runnable {
    final /* synthetic */ a tDu;

    FTSSOSHomeWebViewUI$a$4(a aVar) {
        this.tDu = aVar;
    }

    public final void run() {
        a.a(this.tDu).clear();
        this.tDu.notifyDataSetChanged();
    }
}
