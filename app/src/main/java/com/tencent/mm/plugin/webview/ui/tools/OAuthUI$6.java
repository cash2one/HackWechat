package com.tencent.mm.plugin.webview.ui.tools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class OAuthUI$6 implements OnMenuItemClickListener {
    final /* synthetic */ OAuthUI twM;

    OAuthUI$6(OAuthUI oAuthUI) {
        this.twM = oAuthUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (OAuthUI.b(this.twM) != null) {
            OAuthUI.b(this.twM);
        }
        this.twM.ptK.stopLoading();
        this.twM.J(false, false);
        OAuthUI.c(this.twM);
        return false;
    }
}
