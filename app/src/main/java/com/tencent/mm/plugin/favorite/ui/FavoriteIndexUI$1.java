package com.tencent.mm.plugin.favorite.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FavoriteIndexUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ FavoriteIndexUI mtS;

    FavoriteIndexUI$1(FavoriteIndexUI favoriteIndexUI) {
        this.mtS = favoriteIndexUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (FavoriteIndexUI.a(this.mtS).mup) {
            FavoriteIndexUI.b(this.mtS);
        } else {
            this.mtS.finish();
        }
        return true;
    }
}
