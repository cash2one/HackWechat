package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.a;
import com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.c;

class FTSSOSHomeWebViewUI$a$2 implements Runnable {
    final /* synthetic */ a tDu;
    final /* synthetic */ c tDv;

    FTSSOSHomeWebViewUI$a$2(a aVar, c cVar) {
        this.tDu = aVar;
        this.tDv = cVar;
    }

    public final void run() {
        a.a(this.tDu).remove(this.tDv);
        this.tDu.notifyDataSetChanged();
    }
}
