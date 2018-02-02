package com.tencent.mm.plugin.search.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FTSBaseUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ FTSBaseUI qcb;

    FTSBaseUI$2(FTSBaseUI fTSBaseUI) {
        this.qcb = fTSBaseUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qcb.finish();
        return true;
    }
}
