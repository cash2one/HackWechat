package com.tencent.mm.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SingleChatInfoUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ SingleChatInfoUI xMD;

    SingleChatInfoUI$4(SingleChatInfoUI singleChatInfoUI) {
        this.xMD = singleChatInfoUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.xMD.finish();
        return true;
    }
}
