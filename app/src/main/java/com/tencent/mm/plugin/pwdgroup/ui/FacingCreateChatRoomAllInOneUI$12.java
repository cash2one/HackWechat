package com.tencent.mm.plugin.pwdgroup.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FacingCreateChatRoomAllInOneUI$12 implements OnMenuItemClickListener {
    final /* synthetic */ FacingCreateChatRoomAllInOneUI pmn;

    FacingCreateChatRoomAllInOneUI$12(FacingCreateChatRoomAllInOneUI facingCreateChatRoomAllInOneUI) {
        this.pmn = facingCreateChatRoomAllInOneUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.pmn.finish();
        return false;
    }
}
