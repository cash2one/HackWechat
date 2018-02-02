package com.tencent.mm.plugin.favorite.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.sdk.platformtools.x;

class FavBaseUI$4 implements OnScrollListener {
    final /* synthetic */ FavBaseUI mrW;

    FavBaseUI$4(FavBaseUI favBaseUI) {
        this.mrW = favBaseUI;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i != 0) {
            return;
        }
        if (h.getFavItemInfoStorage().p(this.mrW.aJb().aJr(), this.mrW.aJb().getType())) {
            x.v("MicroMsg.FavoriteBaseUI", "has shown all, do not load data");
        } else if (FavBaseUI.a(this.mrW)) {
            x.i("MicroMsg.FavoriteBaseUI", "force bottom load data");
            FavBaseUI.b(this.mrW);
        }
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
