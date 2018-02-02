package com.tencent.mm.plugin.webview.ui.tools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WebViewDownloadUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ WebViewDownloadUI txr;

    WebViewDownloadUI$1(WebViewDownloadUI webViewDownloadUI) {
        this.txr = webViewDownloadUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.txr.finish();
        return true;
    }
}
