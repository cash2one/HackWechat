package com.tencent.mm.plugin.chatroom.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class DelChatroomMemberUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ DelChatroomMemberUI laP;

    DelChatroomMemberUI$1(DelChatroomMemberUI delChatroomMemberUI) {
        this.laP = delChatroomMemberUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.laP.finish();
        return true;
    }
}
