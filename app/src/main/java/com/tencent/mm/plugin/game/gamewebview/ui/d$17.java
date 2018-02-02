package com.tencent.mm.plugin.game.gamewebview.ui;

class d$17 implements Runnable {
    final /* synthetic */ String iTF;
    final /* synthetic */ String iXg;
    final /* synthetic */ d mZC;

    d$17(d dVar, String str, String str2) {
        this.mZC = dVar;
        this.iXg = str;
        this.iTF = str2;
    }

    public final void run() {
        if (d.n(this.mZC) != null) {
            d.n(this.mZC).cJ(this.iXg, this.iTF);
        }
    }
}
