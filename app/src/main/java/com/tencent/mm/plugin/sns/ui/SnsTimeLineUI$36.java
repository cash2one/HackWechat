package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SnsTimeLineUI$36 implements OnMenuItemClickListener {
    final /* synthetic */ SnsTimeLineUI rIN;

    SnsTimeLineUI$36(SnsTimeLineUI snsTimeLineUI) {
        this.rIN = snsTimeLineUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.rIN.aWs();
        this.rIN.finish();
        return false;
    }
}
