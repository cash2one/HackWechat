package com.tencent.mm.plugin.webview.ui.tools;

import android.view.MenuItem;
import com.tencent.mm.ui.base.p.d;

class WebViewUI$52 implements d {
    final /* synthetic */ WebViewUI tAv;

    WebViewUI$52(WebViewUI webViewUI) {
        this.tAv = webViewUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        WebViewUI.k(this.tAv, menuItem.getTitle().toString());
    }
}
