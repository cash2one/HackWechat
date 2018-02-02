package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.12;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.24;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i$a;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.HashMap;
import java.util.Map;

class WebViewUI$12$17 implements Runnable {
    final /* synthetic */ String iDZ;
    final /* synthetic */ 12 tAx;

    WebViewUI$12$17(12 12, String str) {
        this.tAx = 12;
        this.iDZ = str;
    }

    public final void run() {
        if (this.tAx.tAv.tlx != null) {
            d dVar = this.tAx.tAv.tlx;
            String str = this.iDZ;
            Map hashMap = new HashMap();
            hashMap.put("err_msg", str);
            ag.y(new 24(dVar, i$a.a("onBeaconMonitoring", hashMap, dVar.tGS, dVar.tGT)));
        }
    }
}
