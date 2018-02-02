package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingSnsBackgroundUI$5 implements OnMenuItemClickListener {
    final /* synthetic */ SettingSnsBackgroundUI rwG;

    SettingSnsBackgroundUI$5(SettingSnsBackgroundUI settingSnsBackgroundUI) {
        this.rwG = settingSnsBackgroundUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.rwG.finish();
        return true;
    }
}
