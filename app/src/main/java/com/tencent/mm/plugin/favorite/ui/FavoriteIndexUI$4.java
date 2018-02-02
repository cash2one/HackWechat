package com.tencent.mm.plugin.favorite.ui;

import android.app.Dialog;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.List;

class FavoriteIndexUI$4 implements Runnable {
    final /* synthetic */ List msj;
    final /* synthetic */ Dialog msk;
    final /* synthetic */ FavoriteIndexUI mtS;
    final /* synthetic */ String[] mtV;

    FavoriteIndexUI$4(FavoriteIndexUI favoriteIndexUI, List list, String[] strArr, Dialog dialog) {
        this.mtS = favoriteIndexUI;
        this.msj = list;
        this.mtV = strArr;
        this.msk = dialog;
    }

    public final void run() {
        j.a(this.msj, this.mtV);
        ag.y(new 1(this));
    }
}
