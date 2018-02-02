package com.tencent.mm.plugin.record.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.widget.g;

class RecordMsgDetailUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ RecordMsgDetailUI pGl;

    RecordMsgDetailUI$3(RecordMsgDetailUI recordMsgDetailUI) {
        this.pGl = recordMsgDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        g gVar = new g(this.pGl.mController.xIM, g.ztp, false);
        gVar.rKC = new 1(this);
        gVar.rKD = new 2(this);
        gVar.bUk();
        return true;
    }
}
