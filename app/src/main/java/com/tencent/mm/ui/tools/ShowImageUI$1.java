package com.tencent.mm.ui.tools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ShowImageUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ShowImageUI zmY;

    ShowImageUI$1(ShowImageUI showImageUI) {
        this.zmY = showImageUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.zmY.finish();
        return true;
    }
}
