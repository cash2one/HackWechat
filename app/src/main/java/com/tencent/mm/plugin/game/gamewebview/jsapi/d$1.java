package com.tencent.mm.plugin.game.gamewebview.jsapi;

class d$1 implements Runnable {
    final /* synthetic */ int gOK;
    final /* synthetic */ String iTF;
    final /* synthetic */ String jbS;
    final /* synthetic */ d mWk;

    d$1(d dVar, String str, String str2, int i) {
        this.mWk = dVar;
        this.jbS = str;
        this.iTF = str2;
        this.gOK = i;
    }

    public final void run() {
        this.mWk.t(this.jbS, this.iTF, this.gOK);
    }
}
