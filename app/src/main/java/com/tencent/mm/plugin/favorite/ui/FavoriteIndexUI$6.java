package com.tencent.mm.plugin.favorite.ui;

import com.tencent.mm.plugin.favorite.a.c;
import java.util.ArrayList;

class FavoriteIndexUI$6 implements Runnable {
    final /* synthetic */ FavoriteIndexUI mtS;
    final /* synthetic */ ArrayList mtX;

    FavoriteIndexUI$6(FavoriteIndexUI favoriteIndexUI, ArrayList arrayList) {
        this.mtS = favoriteIndexUI;
        this.mtX = arrayList;
    }

    public final void run() {
        this.mtS.mrF = true;
        c.aJ(this.mtX);
    }
}
