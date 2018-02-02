package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.12;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;

class WebViewUI$12$25 implements Runnable {
    final /* synthetic */ String mZF;
    final /* synthetic */ 12 tAx;
    final /* synthetic */ String tvu;
    final /* synthetic */ Bundle tvv;
    final /* synthetic */ boolean tvw;

    WebViewUI$12$25(12 12, String str, String str2, Bundle bundle, boolean z) {
        this.tAx = 12;
        this.tvu = str;
        this.mZF = str2;
        this.tvv = bundle;
        this.tvw = z;
    }

    public final void run() {
        this.tAx.tAv.tlx.a(this.tvu, this.mZF, i.aa(this.tvv), this.tvw);
    }
}
