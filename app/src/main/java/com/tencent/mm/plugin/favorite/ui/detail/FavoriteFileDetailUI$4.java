package com.tencent.mm.plugin.favorite.ui.detail;

import android.app.Dialog;

class FavoriteFileDetailUI$4 implements Runnable {
    final /* synthetic */ Dialog msk;
    final /* synthetic */ FavoriteFileDetailUI mwo;

    FavoriteFileDetailUI$4(FavoriteFileDetailUI favoriteFileDetailUI, Dialog dialog) {
        this.mwo = favoriteFileDetailUI;
        this.msk = dialog;
    }

    public final void run() {
        this.msk.dismiss();
    }
}
