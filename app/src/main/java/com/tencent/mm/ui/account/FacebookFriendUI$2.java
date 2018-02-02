package com.tencent.mm.ui.account;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FacebookFriendUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ FacebookFriendUI xNZ;

    FacebookFriendUI$2(FacebookFriendUI facebookFriendUI) {
        this.xNZ = facebookFriendUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.xNZ.aWs();
        this.xNZ.finish();
        return true;
    }
}
