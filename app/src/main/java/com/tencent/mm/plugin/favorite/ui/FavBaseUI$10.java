package com.tencent.mm.plugin.favorite.ui;

class FavBaseUI$10 implements Runnable {
    final /* synthetic */ FavBaseUI mrW;

    FavBaseUI$10(FavBaseUI favBaseUI) {
        this.mrW = favBaseUI;
    }

    public final void run() {
        synchronized (FavBaseUI.g(this.mrW)) {
            this.mrW.aJc();
            this.mrW.aJb().aJu();
            this.mrW.aJf();
        }
    }
}
