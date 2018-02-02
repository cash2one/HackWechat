package com.tencent.mm.plugin.game.gamewebview.ui;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.smtt.sdk.WebView;

class d$28 implements Runnable {
    final /* synthetic */ d mZC;

    d$28(d dVar) {
        this.mZC = dVar;
    }

    public final void run() {
        e e = d.e(this.mZC);
        int K = d.K(this.mZC);
        String L = d.L(this.mZC);
        e.setBackgroundColor(K);
        if (bh.ou(L).equals("black")) {
            e.lVg.setTextColor(WebView.NIGHT_MODE_COLOR);
            e.kQn.setColorFilter(WebView.NIGHT_MODE_COLOR);
            e.mZQ.setColorFilter(WebView.NIGHT_MODE_COLOR);
            return;
        }
        e.lVg.setTextColor(-1);
        e.kQn.clearColorFilter();
        e.mZQ.clearColorFilter();
    }
}
