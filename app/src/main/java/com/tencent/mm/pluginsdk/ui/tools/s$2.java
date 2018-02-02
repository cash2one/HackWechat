package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.xweb.WebView;

class s$2 implements Runnable {
    final /* synthetic */ String tAZ;
    final /* synthetic */ WebView vzf;
    final /* synthetic */ boolean vzg;
    final /* synthetic */ String vzh;

    s$2(boolean z, WebView webView, String str, String str2) {
        this.vzg = z;
        this.vzf = webView;
        this.vzh = str;
        this.tAZ = str2;
    }

    public final void run() {
        if (this.vzg) {
            this.vzf.evaluateJavascript("javascript:document.getElementById('_edw_iframe_').src = '" + this.vzh + "' + " + this.tAZ, null);
        } else {
            this.vzf.evaluateJavascript("javascript:console.log('" + this.vzh + "' + " + this.tAZ + ")", null);
        }
    }
}
