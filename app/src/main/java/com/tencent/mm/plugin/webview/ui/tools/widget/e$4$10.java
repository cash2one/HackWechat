package com.tencent.mm.plugin.webview.ui.tools.widget;

import com.tencent.mm.plugin.webview.ui.tools.widget.e.4;

class e$4$10 implements Runnable {
    final /* synthetic */ String fgU;
    final /* synthetic */ int irm;
    final /* synthetic */ long tAU;
    final /* synthetic */ 4 tKr;

    e$4$10(4 4, String str, long j, int i) {
        this.tKr = 4;
        this.fgU = str;
        this.tAU = j;
        this.irm = i;
    }

    public final void run() {
        if (this.tKr.tKp.tFj != null && this.tKr.tKp.tGR != null && this.tKr.tKp.tGR.bSs() != null && this.tKr.tKp.tGR.bSs().gn(42)) {
            this.tKr.tKp.tFj.g(this.fgU, this.tAU, this.irm);
        }
    }
}
