package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.12;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.4;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i$a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class WebViewUI$12$14 implements Runnable {
    final /* synthetic */ String tAA;
    final /* synthetic */ boolean tAF;
    final /* synthetic */ 12 tAx;

    WebViewUI$12$14(12 12, String str, boolean z) {
        this.tAx = 12;
        this.tAA = str;
        this.tAF = z;
    }

    public final void run() {
        if (this.tAx.tAv.tlx != null) {
            d dVar = this.tAx.tAv.tlx;
            String str = this.tAA;
            boolean z = this.tAF;
            if (dVar.tGQ) {
                x.i("MicroMsg.JsApiHandler", "onWXDeviceBindStateChange: device id = %s, isBound = %s", new Object[]{str, Boolean.valueOf(z)});
                if (bh.ov(str)) {
                    x.e("MicroMsg.JsApiHandler", "parameter error!!!");
                    return;
                }
                Map hashMap = new HashMap();
                hashMap.put("deviceId", str);
                if (z) {
                    hashMap.put("state", "bind");
                } else {
                    hashMap.put("state", "unbind");
                }
                ag.y(new 4(dVar, i$a.a("onWXDeviceBindStateChange", hashMap, dVar.tGS, dVar.tGT)));
                return;
            }
            x.e("MicroMsg.JsApiHandler", "onWXDeviceBindStateChange fail, not ready");
        }
    }
}
