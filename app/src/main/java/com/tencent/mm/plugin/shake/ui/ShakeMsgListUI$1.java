package com.tencent.mm.plugin.shake.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ShakeMsgListUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ShakeMsgListUI qqQ;

    ShakeMsgListUI$1(ShakeMsgListUI shakeMsgListUI) {
        this.qqQ = shakeMsgListUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qqQ.aWs();
        this.qqQ.finish();
        return true;
    }
}
