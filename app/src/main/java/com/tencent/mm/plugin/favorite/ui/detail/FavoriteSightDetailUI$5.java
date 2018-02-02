package com.tencent.mm.plugin.favorite.ui.detail;

import com.tencent.mm.plugin.favorite.a.j;

class FavoriteSightDetailUI$5 implements Runnable {
    final /* synthetic */ FavoriteSightDetailUI mxe;

    FavoriteSightDetailUI$5(FavoriteSightDetailUI favoriteSightDetailUI) {
        this.mxe = favoriteSightDetailUI;
    }

    public final void run() {
        if (!FavoriteSightDetailUI.a(this.mxe).isDone() || !j.e(FavoriteSightDetailUI.b(this.mxe)) || FavoriteSightDetailUI.d(this.mxe) == null || !FavoriteSightDetailUI.d(this.mxe).isPlaying()) {
            FavoriteSightDetailUI.a(this.mxe, true);
        }
    }
}
