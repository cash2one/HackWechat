package com.tencent.mm.plugin.chatroom.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ChatroomInfoUI$5 implements OnMenuItemClickListener {
    final /* synthetic */ ChatroomInfoUI lal;

    ChatroomInfoUI$5(ChatroomInfoUI chatroomInfoUI) {
        this.lal = chatroomInfoUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.lal.finish();
        return true;
    }
}
