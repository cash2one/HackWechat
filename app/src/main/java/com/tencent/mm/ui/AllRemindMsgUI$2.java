package com.tencent.mm.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class AllRemindMsgUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ AllRemindMsgUI xDG;

    AllRemindMsgUI$2(AllRemindMsgUI allRemindMsgUI) {
        this.xDG = allRemindMsgUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.xDG.onBackPressed();
        return true;
    }
}
