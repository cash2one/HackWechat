package com.tencent.mm.plugin.chatroom.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class RoomAnnouncementUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ RoomAnnouncementUI lbs;

    RoomAnnouncementUI$3(RoomAnnouncementUI roomAnnouncementUI) {
        this.lbs = roomAnnouncementUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.lbs.setResult(0);
        this.lbs.finish();
        return true;
    }
}
