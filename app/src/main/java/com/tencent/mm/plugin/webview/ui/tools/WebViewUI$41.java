package com.tencent.mm.plugin.webview.ui.tools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WebViewUI$41 implements OnMenuItemClickListener {
    final /* synthetic */ String hpU;
    final /* synthetic */ WebViewUI tAv;
    final /* synthetic */ boolean tBn;

    WebViewUI$41(WebViewUI webViewUI, boolean z, String str) {
        this.tAv = webViewUI;
        this.tBn = z;
        this.hpU = str;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (this.tBn) {
            WebViewUI.i(this.tAv, this.hpU);
        } else {
            this.tAv.aPz();
        }
        return true;
    }
}
