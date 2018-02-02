package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.12;

class WebViewUI$12$23 implements Runnable {
    final /* synthetic */ Bundle fhp;
    final /* synthetic */ 12 tAx;

    WebViewUI$12$23(12 12, Bundle bundle) {
        this.tAx = 12;
        this.fhp = bundle;
    }

    public final void run() {
        if (this.tAx.tAv.tlx != null && this.tAx.tAv.juR != null && this.tAx.tAv.juR.bSs() != null && this.tAx.tAv.juR.bSs().gn(42)) {
            this.tAx.tAv.tlx.f(this.fhp, "download_removed");
        }
    }
}
