package com.tencent.mm.plugin.chatroom.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SeeAccessVerifyInfoUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SeeAccessVerifyInfoUI lcQ;

    SeeAccessVerifyInfoUI$1(SeeAccessVerifyInfoUI seeAccessVerifyInfoUI) {
        this.lcQ = seeAccessVerifyInfoUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.lcQ.finish();
        return true;
    }
}
