package com.tencent.mm.plugin.record.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class RecordMsgDetailUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ RecordMsgDetailUI pGl;

    RecordMsgDetailUI$1(RecordMsgDetailUI recordMsgDetailUI) {
        this.pGl = recordMsgDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.pGl.finish();
        return true;
    }
}
