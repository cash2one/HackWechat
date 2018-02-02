package com.tencent.mm.plugin.webview.ui.tools;

import android.os.RemoteException;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.x;

class WebViewUI$32 implements OnMenuItemClickListener {
    final /* synthetic */ String jvk;
    final /* synthetic */ String jvl;
    final /* synthetic */ WebViewUI tAv;

    WebViewUI$32(WebViewUI webViewUI, String str, String str2) {
        this.tAv = webViewUI;
        this.jvk = str;
        this.jvl = str2;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        try {
            this.tAv.juQ.g(this.jvk, this.tAv.aPk(), this.jvl, this.tAv.juU, this.tAv.juV);
            x.i("MicroMsg.WebViewUI", "onMenuItemClick recognize qbcode");
        } catch (RemoteException e) {
            x.e("MicroMsg.WebViewUI", "recognize qbar result failed");
        }
        return false;
    }
}
