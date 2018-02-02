package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ShareToQQWeiboUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ShareToQQWeiboUI tJW;

    ShareToQQWeiboUI$1(ShareToQQWeiboUI shareToQQWeiboUI) {
        this.tJW = shareToQQWeiboUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.tJW.aWs();
        this.tJW.finish();
        return true;
    }
}
