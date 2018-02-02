package com.tencent.mm.plugin.favorite.ui;

import android.app.Dialog;
import com.tencent.mm.R;
import com.tencent.mm.ui.snackbar.a;

class FavoriteIndexUI$5 implements Runnable {
    final /* synthetic */ Dialog msk;
    final /* synthetic */ FavoriteIndexUI mtS;

    FavoriteIndexUI$5(FavoriteIndexUI favoriteIndexUI, Dialog dialog) {
        this.mtS = favoriteIndexUI;
        this.msk = dialog;
    }

    public final void run() {
        this.msk.dismiss();
        a.h(this.mtS, this.mtS.getString(R.l.eic));
    }
}
