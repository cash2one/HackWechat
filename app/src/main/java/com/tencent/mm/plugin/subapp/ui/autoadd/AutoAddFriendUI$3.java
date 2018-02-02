package com.tencent.mm.plugin.subapp.ui.autoadd;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class AutoAddFriendUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ AutoAddFriendUI rWN;

    AutoAddFriendUI$3(AutoAddFriendUI autoAddFriendUI) {
        this.rWN = autoAddFriendUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.rWN.finish();
        return true;
    }
}
