package com.tencent.mm.plugin.game.gamewebview.ui;

import com.tencent.mm.sdk.platformtools.bh;

class d$23 implements Runnable {
    final /* synthetic */ String icx;
    final /* synthetic */ int irj;
    final /* synthetic */ d mZC;

    public d$23(d dVar, String str, int i) {
        this.mZC = dVar;
        this.icx = str;
        this.irj = i;
    }

    public final void run() {
        if (d.e(this.mZC) != null) {
            if (!bh.ov(this.icx)) {
                d.e(this.mZC).xv(this.icx);
            }
            e e = d.e(this.mZC);
            e.lVg.setTextColor(this.irj);
        }
    }
}
