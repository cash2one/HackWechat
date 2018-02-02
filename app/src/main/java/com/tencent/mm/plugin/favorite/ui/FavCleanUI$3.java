package com.tencent.mm.plugin.favorite.ui;

import com.tencent.mm.plugin.favorite.a.a.a;
import com.tencent.mm.sdk.platformtools.x;

class FavCleanUI$3 implements a {
    final /* synthetic */ FavCleanUI msh;

    FavCleanUI$3(FavCleanUI favCleanUI) {
        this.msh = favCleanUI;
    }

    public final void onFinish() {
        x.i("MicroMsg.FavCleanUI", "FavCleanFirstLoader onRefreshed()");
        FavCleanUI.c(this.msh);
        FavCleanUI.d(this.msh);
    }
}
