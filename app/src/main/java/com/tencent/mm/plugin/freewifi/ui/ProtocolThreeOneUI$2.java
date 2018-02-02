package com.tencent.mm.plugin.freewifi.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ProtocolThreeOneUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ ProtocolThreeOneUI mIQ;

    ProtocolThreeOneUI$2(ProtocolThreeOneUI protocolThreeOneUI) {
        this.mIQ = protocolThreeOneUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        ProtocolThreeOneUI.c(this.mIQ);
        return true;
    }
}
