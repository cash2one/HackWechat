package com.tencent.mm.plugin.shake.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ShakeSayHiListUI$9 implements OnMenuItemClickListener {
    final /* synthetic */ ShakeSayHiListUI qsr;

    ShakeSayHiListUI$9(ShakeSayHiListUI shakeSayHiListUI) {
        this.qsr = shakeSayHiListUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qsr.aWs();
        this.qsr.finish();
        return true;
    }
}
