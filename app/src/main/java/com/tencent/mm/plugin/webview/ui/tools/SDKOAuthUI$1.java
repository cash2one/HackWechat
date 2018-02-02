package com.tencent.mm.plugin.webview.ui.tools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SDKOAuthUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SDKOAuthUI txf;

    SDKOAuthUI$1(SDKOAuthUI sDKOAuthUI) {
        this.txf = sDKOAuthUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        SDKOAuthUI.a(this.txf);
        this.txf.finish();
        return true;
    }
}
