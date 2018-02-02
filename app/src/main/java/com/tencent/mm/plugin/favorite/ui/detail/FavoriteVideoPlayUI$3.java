package com.tencent.mm.plugin.favorite.ui.detail;

import android.app.Dialog;

class FavoriteVideoPlayUI$3 implements Runnable {
    final /* synthetic */ Dialog msk;
    final /* synthetic */ FavoriteVideoPlayUI mxB;

    FavoriteVideoPlayUI$3(FavoriteVideoPlayUI favoriteVideoPlayUI, Dialog dialog) {
        this.mxB = favoriteVideoPlayUI;
        this.msk = dialog;
    }

    public final void run() {
        this.msk.dismiss();
    }
}
