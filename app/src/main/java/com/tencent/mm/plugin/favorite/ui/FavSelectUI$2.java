package com.tencent.mm.plugin.favorite.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FavSelectUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ FavSelectUI mtu;

    FavSelectUI$2(FavSelectUI favSelectUI) {
        this.mtu = favSelectUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intent intent = new Intent(this.mtu.mController.xIM, FavSearchUI.class);
        intent.putExtra("key_to_user", FavSelectUI.b(this.mtu));
        intent.putExtra("key_fav_item_id", FavSelectUI.c(this.mtu));
        intent.putExtra("key_search_type", 1);
        intent.putExtra("key_enter_fav_search_from", 1);
        this.mtu.startActivityForResult(intent, 0);
        return true;
    }
}
