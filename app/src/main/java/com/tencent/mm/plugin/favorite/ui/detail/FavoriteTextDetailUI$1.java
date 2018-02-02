package com.tencent.mm.plugin.favorite.ui.detail;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FavoriteTextDetailUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ FavoriteTextDetailUI mxo;

    FavoriteTextDetailUI$1(FavoriteTextDetailUI favoriteTextDetailUI) {
        this.mxo = favoriteTextDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mxo.finish();
        return true;
    }
}
