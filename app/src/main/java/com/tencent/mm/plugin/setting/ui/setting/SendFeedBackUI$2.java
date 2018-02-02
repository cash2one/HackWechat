package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SendFeedBackUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ SendFeedBackUI qhI;

    SendFeedBackUI$2(SendFeedBackUI sendFeedBackUI) {
        this.qhI = sendFeedBackUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qhI.aWs();
        this.qhI.finish();
        return true;
    }
}
