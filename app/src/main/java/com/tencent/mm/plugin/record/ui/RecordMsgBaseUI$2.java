package com.tencent.mm.plugin.record.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class RecordMsgBaseUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ RecordMsgBaseUI pGf;

    RecordMsgBaseUI$2(RecordMsgBaseUI recordMsgBaseUI) {
        this.pGf = recordMsgBaseUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.pGf.finish();
        return true;
    }
}
