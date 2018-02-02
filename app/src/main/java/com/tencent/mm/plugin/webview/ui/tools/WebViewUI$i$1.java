package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.i;

class WebViewUI$i$1 implements Runnable {
    final /* synthetic */ i tBw;
    final /* synthetic */ String val$url;

    WebViewUI$i$1(i iVar, String str) {
        this.tBw = iVar;
        this.val$url = str;
    }

    public final void run() {
        this.tBw.tAv.BO(this.val$url);
    }
}
