package com.tencent.mm.plugin.webview.ui.tools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WebViewDownloadWithX5UI$1 implements OnMenuItemClickListener {
    final /* synthetic */ WebViewDownloadWithX5UI txA;

    WebViewDownloadWithX5UI$1(WebViewDownloadWithX5UI webViewDownloadWithX5UI) {
        this.txA = webViewDownloadWithX5UI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.txA.finish();
        return true;
    }
}
