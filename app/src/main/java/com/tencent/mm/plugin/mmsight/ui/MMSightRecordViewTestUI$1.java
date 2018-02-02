package com.tencent.mm.plugin.mmsight.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class MMSightRecordViewTestUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ MMSightRecordViewTestUI oBx;

    MMSightRecordViewTestUI$1(MMSightRecordViewTestUI mMSightRecordViewTestUI) {
        this.oBx = mMSightRecordViewTestUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.oBx.finish();
        return false;
    }
}
