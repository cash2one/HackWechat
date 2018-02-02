package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.g;

class WebViewUI$39 implements Runnable {
    final /* synthetic */ g nal;
    final /* synthetic */ WebViewUI tAv;

    WebViewUI$39(WebViewUI webViewUI, g gVar) {
        this.tAv = webViewUI;
        this.nal = gVar;
    }

    public final void run() {
        if (this.tAv.isFinishing() || this.tAv.tzO) {
            x.i("MicroMsg.WebViewUI", "tryShow bottom sheet failed, the activity has been destroyed.");
        } else {
            this.nal.bUk();
        }
    }
}
