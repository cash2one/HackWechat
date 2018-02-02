package com.tencent.mm.ui.bindgooglecontact;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class GoogleFriendUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ GoogleFriendUI ykV;

    GoogleFriendUI$1(GoogleFriendUI googleFriendUI) {
        this.ykV = googleFriendUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.ykV.finish();
        return true;
    }
}
