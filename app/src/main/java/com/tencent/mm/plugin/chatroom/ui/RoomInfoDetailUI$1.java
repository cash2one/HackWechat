package com.tencent.mm.plugin.chatroom.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class RoomInfoDetailUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ RoomInfoDetailUI lbX;

    RoomInfoDetailUI$1(RoomInfoDetailUI roomInfoDetailUI) {
        this.lbX = roomInfoDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.lbX.finish();
        return true;
    }
}
