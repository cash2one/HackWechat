package com.tencent.mm.plugin.game.gamewebview.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.ui.tools.d;

class d$26 implements Runnable {
    final /* synthetic */ String jEq;
    final /* synthetic */ d mZC;

    public d$26(d dVar, String str) {
        this.mZC = dVar;
        this.jEq = str;
    }

    public final void run() {
        d.h(this.mZC).AF(d.aK(this.jEq, this.mZC.getResources().getColor(R.e.buh)));
        d.h(this.mZC).bSv();
    }
}
