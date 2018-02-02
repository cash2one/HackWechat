package com.tencent.mm.plugin.webview.ui.tools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.b;

class WebViewUI$30 implements OnMenuItemClickListener {
    final /* synthetic */ String jvh;
    final /* synthetic */ WebViewUI tAv;

    WebViewUI$30(WebViewUI webViewUI, String str) {
        this.tAv = webViewUI;
        this.jvh = str;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        boolean isSDCardAvailable;
        try {
            isSDCardAvailable = this.tAv.juQ.isSDCardAvailable();
        } catch (Exception e) {
            x.e("MicroMsg.WebViewUI", "onMenuItemClick fail, ex = " + e.getMessage());
            isSDCardAvailable = false;
        }
        try {
            s.a(this.tAv, this.jvh, b.cIj().getCookie(this.jvh), isSDCardAvailable);
        } catch (Exception e2) {
            x.e("MicroMsg.WebViewUI", "save to sdcard failed : %s", new Object[]{e2.getMessage()});
        }
        return true;
    }
}
