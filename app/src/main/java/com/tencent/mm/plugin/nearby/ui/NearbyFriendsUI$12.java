package com.tencent.mm.plugin.nearby.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class NearbyFriendsUI$12 implements OnMenuItemClickListener {
    final /* synthetic */ NearbyFriendsUI oOS;

    NearbyFriendsUI$12(NearbyFriendsUI nearbyFriendsUI) {
        this.oOS = nearbyFriendsUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.oOS.finish();
        return true;
    }
}
