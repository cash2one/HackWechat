package com.tencent.mm.plugin.record.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class RecordMsgImageUI$6 implements OnMenuItemClickListener {
    final /* synthetic */ RecordMsgImageUI pGz;

    RecordMsgImageUI$6(RecordMsgImageUI recordMsgImageUI) {
        this.pGz = recordMsgImageUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.pGz.finish();
        return true;
    }
}
