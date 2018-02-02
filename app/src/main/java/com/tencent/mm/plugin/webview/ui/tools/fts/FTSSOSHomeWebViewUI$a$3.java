package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.a;
import com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.c;
import java.util.List;

class FTSSOSHomeWebViewUI$a$3 implements Runnable {
    final /* synthetic */ List tDt;
    final /* synthetic */ a tDu;

    FTSSOSHomeWebViewUI$a$3(a aVar, List list) {
        this.tDu = aVar;
        this.tDt = list;
    }

    public final void run() {
        for (c cVar : this.tDt) {
            if (!a.a(this.tDu).contains(cVar)) {
                a.a(this.tDu).add(cVar);
            }
        }
        this.tDu.notifyDataSetChanged();
    }
}
