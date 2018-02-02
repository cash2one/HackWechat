package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class AddMoreFriendsByOtherWayUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ AddMoreFriendsByOtherWayUI rYj;

    AddMoreFriendsByOtherWayUI$1(AddMoreFriendsByOtherWayUI addMoreFriendsByOtherWayUI) {
        this.rYj = addMoreFriendsByOtherWayUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.rYj.finish();
        return true;
    }
}
