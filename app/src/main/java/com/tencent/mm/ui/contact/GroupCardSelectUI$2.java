package com.tencent.mm.ui.contact;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class GroupCardSelectUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ GroupCardSelectUI ySK;

    GroupCardSelectUI$2(GroupCardSelectUI groupCardSelectUI) {
        this.ySK = groupCardSelectUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.ySK.finish();
        return true;
    }
}
