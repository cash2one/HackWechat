package com.tencent.mm.plugin.aa.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class AAEntranceUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ AAEntranceUI ihP;

    AAEntranceUI$3(AAEntranceUI aAEntranceUI) {
        this.ihP = aAEntranceUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.ihP.finish();
        return false;
    }
}
