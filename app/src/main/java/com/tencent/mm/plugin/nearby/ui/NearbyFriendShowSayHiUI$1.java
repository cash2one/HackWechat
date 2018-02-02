package com.tencent.mm.plugin.nearby.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class NearbyFriendShowSayHiUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ NearbyFriendShowSayHiUI oOy;

    NearbyFriendShowSayHiUI$1(NearbyFriendShowSayHiUI nearbyFriendShowSayHiUI) {
        this.oOy = nearbyFriendShowSayHiUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.oOy.aWs();
        this.oOy.finish();
        return true;
    }
}
