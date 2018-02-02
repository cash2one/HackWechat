package com.tencent.mm.plugin.favorite.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FavCleanUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ FavCleanUI msh;

    FavCleanUI$1(FavCleanUI favCleanUI) {
        this.msh = favCleanUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.msh.finish();
        return true;
    }
}
