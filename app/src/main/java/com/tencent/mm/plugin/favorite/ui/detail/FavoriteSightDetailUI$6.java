package com.tencent.mm.plugin.favorite.ui.detail;

class FavoriteSightDetailUI$6 implements Runnable {
    final /* synthetic */ int irm;
    final /* synthetic */ FavoriteSightDetailUI mxe;

    FavoriteSightDetailUI$6(FavoriteSightDetailUI favoriteSightDetailUI, int i) {
        this.mxe = favoriteSightDetailUI;
        this.irm = i;
    }

    public final void run() {
        FavoriteSightDetailUI.c(this.mxe).setProgress(this.irm);
    }
}
