package com.tencent.mm.plugin.chatroom.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SelectDateUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ SelectDateUI ldo;

    SelectDateUI$2(SelectDateUI selectDateUI) {
        this.ldo = selectDateUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.ldo.finish();
        return true;
    }
}
