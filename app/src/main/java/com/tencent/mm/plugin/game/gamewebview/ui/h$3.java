package com.tencent.mm.plugin.game.gamewebview.ui;

class h$3 implements Runnable {
    final /* synthetic */ String jve;
    final /* synthetic */ h mZZ;

    public h$3(h hVar, String str) {
        this.mZZ = hVar;
        this.jve = str;
    }

    public final void run() {
        if (h.a(this.mZZ) != null) {
            this.mZZ.juT = this.jve;
            this.mZZ.juS.b(h.a(this.mZZ), new 1(this), null);
            this.mZZ.juS.bBX();
        }
    }
}
