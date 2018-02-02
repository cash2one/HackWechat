package com.tencent.mm.plugin.webview.ui.tools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WebViewUI$20 implements OnMenuItemClickListener {
    final /* synthetic */ WebViewUI tAv;

    WebViewUI$20(WebViewUI webViewUI) {
        this.tAv = webViewUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.tAv.aWs();
        WebViewUI.R(this.tAv);
        return true;
    }
}
