package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.12;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class WebViewUI$12$15 implements Runnable {
    final /* synthetic */ boolean tAG;
    final /* synthetic */ 12 tAx;

    WebViewUI$12$15(12 12, boolean z) {
        this.tAx = 12;
        this.tAG = z;
    }

    public final void run() {
        if (this.tAx.tAv.tlx != null) {
            d dVar = this.tAx.tAv.tlx;
            boolean z = this.tAG;
            if (dVar.tGQ) {
                x.i("MicroMsg.JsApiHandler", "onWXDeviceBTStateChange: state = %s", new Object[]{Boolean.valueOf(z)});
                Map hashMap = new HashMap();
                if (z) {
                    hashMap.put("state", "on");
                } else {
                    hashMap.put("state", "off");
                }
                ag.y(new d$5(dVar, a.a("onWXDeviceBluetoothStateChange", hashMap, dVar.tGS, dVar.tGT)));
                return;
            }
            x.e("MicroMsg.JsApiHandler", "onWXDeviceBTStateChange fail, not ready");
        }
    }
}
