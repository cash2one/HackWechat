package com.tencent.mm.plugin.webview.ui.tools;

import android.net.Uri;
import com.tencent.mm.pluginsdk.model.app.g;

class WebViewUI$57 implements Runnable {
    final /* synthetic */ Uri kvf;
    final /* synthetic */ WebViewUI tAv;

    WebViewUI$57(WebViewUI webViewUI, Uri uri) {
        this.tAv = webViewUI;
        this.kvf = uri;
    }

    public final void run() {
        g.d(this.tAv, this.kvf);
    }
}
