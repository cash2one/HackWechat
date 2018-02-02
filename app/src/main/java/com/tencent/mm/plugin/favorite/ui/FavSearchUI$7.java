package com.tencent.mm.plugin.favorite.ui;

import android.support.v4.view.m.e;
import android.view.MenuItem;

class FavSearchUI$7 implements e {
    final /* synthetic */ FavSearchUI mth;

    FavSearchUI$7(FavSearchUI favSearchUI) {
        this.mth = favSearchUI;
    }

    public final boolean onMenuItemActionExpand(MenuItem menuItem) {
        return true;
    }

    public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
        this.mth.finish();
        return true;
    }
}
