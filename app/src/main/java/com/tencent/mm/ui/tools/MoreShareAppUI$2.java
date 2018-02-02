package com.tencent.mm.ui.tools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class MoreShareAppUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ MoreShareAppUI zlK;

    MoreShareAppUI$2(MoreShareAppUI moreShareAppUI) {
        this.zlK = moreShareAppUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.zlK.finish();
        return true;
    }
}
