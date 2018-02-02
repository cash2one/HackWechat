package com.tencent.mm.plugin.webview.ui.tools.game;

import com.tencent.mm.plugin.webview.ui.tools.game.a.3;

class a$3$3 implements Runnable {
    final /* synthetic */ String icx;
    final /* synthetic */ int irj;
    final /* synthetic */ 3 tFp;

    a$3$3(3 3, String str, int i) {
        this.tFp = 3;
        this.icx = str;
        this.irj = i;
    }

    public final void run() {
        if (this.icx != null) {
            this.tFp.tFo.tFg.setMMTitle(this.icx);
        }
        this.tFp.tFo.tFg.nR(this.irj);
    }
}
