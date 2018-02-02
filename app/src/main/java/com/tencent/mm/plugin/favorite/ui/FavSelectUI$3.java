package com.tencent.mm.plugin.favorite.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FavSelectUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ FavSelectUI mtu;

    FavSelectUI$3(FavSelectUI favSelectUI) {
        this.mtu = favSelectUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mtu.finish();
        return true;
    }
}
