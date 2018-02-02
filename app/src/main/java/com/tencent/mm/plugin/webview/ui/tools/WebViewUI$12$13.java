package com.tencent.mm.plugin.webview.ui.tools;

import android.util.Base64;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.12;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.3;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class WebViewUI$12$13 implements Runnable {
    final /* synthetic */ String lKQ;
    final /* synthetic */ String tAA;
    final /* synthetic */ byte[] tAE;
    final /* synthetic */ 12 tAx;

    WebViewUI$12$13(12 12, String str, byte[] bArr, String str2) {
        this.tAx = 12;
        this.tAA = str;
        this.tAE = bArr;
        this.lKQ = str2;
    }

    public final void run() {
        if (this.tAx.tAv.tlx != null) {
            d dVar = this.tAx.tAv.tlx;
            String str = this.tAA;
            byte[] bArr = this.tAE;
            String str2 = this.lKQ;
            if (dVar.tGQ) {
                x.i("MicroMsg.JsApiHandler", "onReceiveDataFromWXDevice: device id = %s, brandName = %s", new Object[]{str, str2});
                if (bh.ov(str) || bh.ov(str2) || bArr == null) {
                    x.e("MicroMsg.JsApiHandler", "parameter error!!!");
                    return;
                }
                Map hashMap = new HashMap();
                hashMap.put("deviceId", str);
                hashMap.put("base64Data", Base64.encodeToString(bArr, 2));
                ag.y(new 3(dVar, a.a("onReceiveDataFromWXDevice", hashMap, dVar.tGS, dVar.tGT)));
                return;
            }
            x.e("MicroMsg.JsApiHandler", "onReceiveDataFromWXDevice fail, not ready");
        }
    }
}
