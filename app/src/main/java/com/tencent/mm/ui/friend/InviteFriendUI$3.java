package com.tencent.mm.ui.friend;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class InviteFriendUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ InviteFriendUI zcP;

    InviteFriendUI$3(InviteFriendUI inviteFriendUI) {
        this.zcP = inviteFriendUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.zcP.finish();
        return true;
    }
}
