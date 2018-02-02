package com.tencent.mm.plugin.favorite.ui.detail;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FavoriteImgDetailUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ FavoriteImgDetailUI mwK;

    FavoriteImgDetailUI$1(FavoriteImgDetailUI favoriteImgDetailUI) {
        this.mwK = favoriteImgDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mwK.finish();
        return true;
    }
}
