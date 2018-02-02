package com.tencent.mm.plugin.webview.ui.tools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class OAuthUI$5 implements OnMenuItemClickListener {
    final /* synthetic */ OAuthUI twM;

    OAuthUI$5(OAuthUI oAuthUI) {
        this.twM = oAuthUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        OAuthUI.a(this.twM);
        this.twM.finish();
        return true;
    }
}
