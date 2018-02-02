package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class AddMoreFriendsUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ AddMoreFriendsUI rYm;

    AddMoreFriendsUI$1(AddMoreFriendsUI addMoreFriendsUI) {
        this.rYm = addMoreFriendsUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.rYm.finish();
        return true;
    }
}
