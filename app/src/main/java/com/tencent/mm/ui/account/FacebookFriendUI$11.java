package com.tencent.mm.ui.account;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.accountsync.ui.InviteFacebookFriendsUI;

class FacebookFriendUI$11 implements OnMenuItemClickListener {
    final /* synthetic */ FacebookFriendUI xNZ;

    FacebookFriendUI$11(FacebookFriendUI facebookFriendUI) {
        this.xNZ = facebookFriendUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.xNZ.startActivity(new Intent(this.xNZ, InviteFacebookFriendsUI.class));
        return true;
    }
}
