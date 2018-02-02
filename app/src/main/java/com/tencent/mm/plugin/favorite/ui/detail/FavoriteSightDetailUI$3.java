package com.tencent.mm.plugin.favorite.ui.detail;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FavoriteSightDetailUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ FavoriteSightDetailUI mxe;

    FavoriteSightDetailUI$3(FavoriteSightDetailUI favoriteSightDetailUI) {
        this.mxe = favoriteSightDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mxe.finish();
        return true;
    }
}
