package com.tencent.mm.plugin.chatroom.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class RoomUpgradeUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ RoomUpgradeUI lcy;

    RoomUpgradeUI$1(RoomUpgradeUI roomUpgradeUI) {
        this.lcy = roomUpgradeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.lcy.finish();
        return true;
    }
}
