package com.tencent.mm.plugin.favorite.ui.detail;

import android.app.Dialog;
import com.tencent.mm.R;
import com.tencent.mm.ui.snackbar.a;

class FavoriteImgDetailUI$8 implements Runnable {
    final /* synthetic */ Dialog msk;
    final /* synthetic */ FavoriteImgDetailUI mwK;

    FavoriteImgDetailUI$8(FavoriteImgDetailUI favoriteImgDetailUI, Dialog dialog) {
        this.mwK = favoriteImgDetailUI;
        this.msk = dialog;
    }

    public final void run() {
        this.msk.dismiss();
        a.h(this.mwK, this.mwK.getString(R.l.eic));
    }
}
