package com.tencent.mm.plugin.record.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class RecordMsgFileUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ RecordMsgFileUI pGq;

    RecordMsgFileUI$1(RecordMsgFileUI recordMsgFileUI) {
        this.pGq = recordMsgFileUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.pGq.finish();
        return true;
    }
}
