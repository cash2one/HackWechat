package com.tencent.mm.plugin.webview.ui.tools.widget;

import com.tencent.mm.plugin.webview.ui.tools.widget.e.4;

class e$4$13 implements Runnable {
    final /* synthetic */ int ikE;
    final /* synthetic */ String jjz;
    final /* synthetic */ 4 tKr;

    e$4$13(4 4, String str, int i) {
        this.tKr = 4;
        this.jjz = str;
        this.ikE = i;
    }

    public final void run() {
        if (this.tKr.tKp.tFj != null) {
            this.tKr.tKp.tFj.cF(this.jjz, this.ikE);
        }
    }
}
