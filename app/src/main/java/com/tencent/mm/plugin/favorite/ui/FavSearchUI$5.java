package com.tencent.mm.plugin.favorite.ui;

import com.tencent.mm.plugin.favorite.h;

class FavSearchUI$5 implements Runnable {
    final /* synthetic */ FavSearchUI mth;

    FavSearchUI$5(FavSearchUI favSearchUI) {
        this.mth = favSearchUI;
    }

    public final void run() {
        FavSearchUI.a(this.mth, h.getFavItemInfoStorage().aIi());
    }
}
