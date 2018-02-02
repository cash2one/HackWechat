package com.tencent.mm.plugin.favorite.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FavTagEditUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ FavTagEditUI mtH;

    FavTagEditUI$1(FavTagEditUI favTagEditUI) {
        this.mtH = favTagEditUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        FavTagEditUI.a(this.mtH);
        return true;
    }
}
