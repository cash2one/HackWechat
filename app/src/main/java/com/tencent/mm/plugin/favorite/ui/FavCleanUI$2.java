package com.tencent.mm.plugin.favorite.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.sdk.platformtools.x;

class FavCleanUI$2 implements OnScrollListener {
    final /* synthetic */ FavCleanUI msh;

    FavCleanUI$2(FavCleanUI favCleanUI) {
        this.msh = favCleanUI;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0 && FavCleanUI.a(this.msh)) {
            x.i("MicroMsg.FavCleanUI", "force bottom load data");
            FavCleanUI.b(this.msh);
        }
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
