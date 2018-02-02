package com.tencent.mm.plugin.nearby.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.widget.g;

class NearbyFriendsUI$14 implements OnMenuItemClickListener {
    final /* synthetic */ NearbyFriendsUI oOS;

    NearbyFriendsUI$14(NearbyFriendsUI nearbyFriendsUI) {
        this.oOS = nearbyFriendsUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        g gVar = new g(this.oOS, g.ztp, false);
        gVar.rKD = new 1(this);
        gVar.rKC = new 2(this);
        gVar.bUk();
        return true;
    }
}
