package com.tencent.mm.plugin.favorite.ui;

import android.app.Dialog;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.List;

class FavoriteIndexUI$3 implements Runnable {
    final /* synthetic */ List msj;
    final /* synthetic */ Dialog msk;
    final /* synthetic */ FavoriteIndexUI mtS;

    FavoriteIndexUI$3(FavoriteIndexUI favoriteIndexUI, List list, Dialog dialog) {
        this.mtS = favoriteIndexUI;
        this.msj = list;
        this.msk = dialog;
    }

    public final void run() {
        j.aK(this.msj);
        ag.y(new 1(this));
    }
}
