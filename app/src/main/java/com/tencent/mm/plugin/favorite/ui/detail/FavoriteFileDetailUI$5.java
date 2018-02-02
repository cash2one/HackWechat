package com.tencent.mm.plugin.favorite.ui.detail;

class FavoriteFileDetailUI$5 implements Runnable {
    final /* synthetic */ FavoriteFileDetailUI mwo;
    final /* synthetic */ float mwq;
    final /* synthetic */ String mwr;

    FavoriteFileDetailUI$5(FavoriteFileDetailUI favoriteFileDetailUI, float f, String str) {
        this.mwo = favoriteFileDetailUI;
        this.mwq = f;
        this.mwr = str;
    }

    public final void run() {
        FavoriteFileDetailUI.u(this.mwo).setProgress((int) this.mwq);
        FavoriteFileDetailUI.v(this.mwo).setText(this.mwr);
    }
}
