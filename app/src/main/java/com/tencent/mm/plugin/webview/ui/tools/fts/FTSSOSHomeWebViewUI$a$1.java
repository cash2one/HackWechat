package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.a;
import com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.c;
import java.util.List;

class FTSSOSHomeWebViewUI$a$1 implements Runnable {
    final /* synthetic */ List tDt;
    final /* synthetic */ a tDu;

    FTSSOSHomeWebViewUI$a$1(a aVar, List list) {
        this.tDu = aVar;
        this.tDt = list;
    }

    public final void run() {
        if (a.a(this.tDu).size() > 0) {
            for (c cVar : a.a(this.tDu)) {
                if (!this.tDt.contains(cVar)) {
                    this.tDt.add(cVar);
                }
            }
        }
        a.a(this.tDu, this.tDt);
        this.tDu.notifyDataSetChanged();
    }
}
