package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.12;

class WebViewUI$12$41 implements Runnable {
    final /* synthetic */ Bundle tAS;
    final /* synthetic */ 12 tAx;

    WebViewUI$12$41(12 12, Bundle bundle) {
        this.tAx = 12;
        this.tAS = bundle;
    }

    public final void run() {
        this.tAS.putInt("height", this.tAx.tAv.bSH());
    }
}
