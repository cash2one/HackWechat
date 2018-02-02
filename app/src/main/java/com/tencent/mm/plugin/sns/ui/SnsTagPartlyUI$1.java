package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SnsTagPartlyUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SnsTagPartlyUI rHh;

    SnsTagPartlyUI$1(SnsTagPartlyUI snsTagPartlyUI) {
        this.rHh = snsTagPartlyUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.rHh.finish();
        return true;
    }
}
