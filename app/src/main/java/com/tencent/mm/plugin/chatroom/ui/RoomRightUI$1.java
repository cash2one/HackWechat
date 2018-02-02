package com.tencent.mm.plugin.chatroom.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class RoomRightUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ RoomRightUI lcb;

    RoomRightUI$1(RoomRightUI roomRightUI) {
        this.lcb = roomRightUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.lcb.aWs();
        this.lcb.finish();
        return true;
    }
}
