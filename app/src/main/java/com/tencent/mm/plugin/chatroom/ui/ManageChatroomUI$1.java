package com.tencent.mm.plugin.chatroom.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ManageChatroomUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ManageChatroomUI lbh;

    ManageChatroomUI$1(ManageChatroomUI manageChatroomUI) {
        this.lbh = manageChatroomUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.lbh.finish();
        return true;
    }
}
