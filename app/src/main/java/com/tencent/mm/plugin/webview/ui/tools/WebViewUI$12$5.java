package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.12;
import java.util.Map;

class WebViewUI$12$5 implements Runnable {
    final /* synthetic */ 12 tAx;
    final /* synthetic */ Map tAz;

    WebViewUI$12$5(12 12, Map map) {
        this.tAx = 12;
        this.tAz = map;
    }

    public final void run() {
        if (this.tAx.tAv.tlx != null) {
            this.tAx.tAv.tlx.am(this.tAz);
        }
    }
}
