package com.tencent.mm.plugin.favorite.ui.detail;

import android.app.Dialog;

class FavoriteSightDetailUI$7 implements Runnable {
    final /* synthetic */ Dialog msk;
    final /* synthetic */ FavoriteSightDetailUI mxe;

    FavoriteSightDetailUI$7(FavoriteSightDetailUI favoriteSightDetailUI, Dialog dialog) {
        this.mxe = favoriteSightDetailUI;
        this.msk = dialog;
    }

    public final void run() {
        this.msk.dismiss();
    }
}
