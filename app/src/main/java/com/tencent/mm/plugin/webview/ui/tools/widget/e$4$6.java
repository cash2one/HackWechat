package com.tencent.mm.plugin.webview.ui.tools.widget;

import com.tencent.mm.plugin.webview.stub.c;
import com.tencent.mm.plugin.webview.ui.tools.widget.e.4;
import com.tencent.mm.sdk.platformtools.x;

class e$4$6 implements Runnable {
    final /* synthetic */ c tAO;
    final /* synthetic */ 4 tKr;

    e$4$6(4 4, c cVar) {
        this.tKr = 4;
        this.tAO = cVar;
    }

    public final void run() {
        try {
            e.a(this.tKr.tKp, this.tAO);
        } catch (Exception e) {
            x.e("MicroMsg.MMWebViewClient", e.getMessage());
        }
    }
}
