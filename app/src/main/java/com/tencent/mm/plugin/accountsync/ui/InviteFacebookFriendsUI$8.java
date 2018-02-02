package com.tencent.mm.plugin.accountsync.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class InviteFacebookFriendsUI$8 implements OnMenuItemClickListener {
    final /* synthetic */ InviteFacebookFriendsUI ilq;

    InviteFacebookFriendsUI$8(InviteFacebookFriendsUI inviteFacebookFriendsUI) {
        this.ilq = inviteFacebookFriendsUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.ilq.aWs();
        this.ilq.finish();
        return true;
    }
}
