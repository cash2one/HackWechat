package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SnsUserUI$10 implements OnMenuItemClickListener {
    final /* synthetic */ SnsUserUI rMb;

    SnsUserUI$10(SnsUserUI snsUserUI) {
        this.rMb = snsUserUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.rMb.finish();
        return true;
    }
}
