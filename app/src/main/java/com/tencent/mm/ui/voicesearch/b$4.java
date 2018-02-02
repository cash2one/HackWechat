package com.tencent.mm.ui.voicesearch;

class b$4 implements Runnable {
    final /* synthetic */ Runnable fgd;
    final /* synthetic */ b zqE;

    b$4(b bVar, Runnable runnable) {
        this.zqE = bVar;
        this.fgd = runnable;
    }

    public final void run() {
        this.fgd.run();
        this.zqE.notifyDataSetChanged();
    }
}
