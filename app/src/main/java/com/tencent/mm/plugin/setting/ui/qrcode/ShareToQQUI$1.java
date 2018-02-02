package com.tencent.mm.plugin.setting.ui.qrcode;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ShareToQQUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ShareToQQUI qgI;

    ShareToQQUI$1(ShareToQQUI shareToQQUI) {
        this.qgI = shareToQQUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qgI.aWs();
        this.qgI.finish();
        return true;
    }
}
