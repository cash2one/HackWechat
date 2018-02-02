package com.tencent.mm.plugin.webview.ui.tools;

import android.util.Base64;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.12;
import com.tencent.mm.plugin.webview.ui.tools.a.b;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONArray;
import org.json.JSONObject;

class WebViewUI$12$11 implements Runnable {
    final /* synthetic */ String tAA;
    final /* synthetic */ byte[] tAB;
    final /* synthetic */ boolean tAC;
    final /* synthetic */ boolean tAD;
    final /* synthetic */ 12 tAx;

    WebViewUI$12$11(12 12, String str, byte[] bArr, boolean z, boolean z2) {
        this.tAx = 12;
        this.tAA = str;
        this.tAB = bArr;
        this.tAC = z;
        this.tAD = z2;
    }

    public final void run() {
        if (this.tAx.tAv.tlx != null) {
            d dVar = this.tAx.tAv.tlx;
            String str = this.tAA;
            byte[] bArr = this.tAB;
            boolean z = this.tAC;
            boolean z2 = this.tAD;
            if (dVar.tGQ) {
                String str2 = "MicroMsg.JsApiHandler";
                String str3 = "onScanWXDeviceResult: device id = %s, isCompleted = %s, %s";
                Object[] objArr = new Object[3];
                objArr[0] = str;
                objArr[1] = Boolean.valueOf(z);
                objArr[2] = Integer.valueOf(bArr == null ? 0 : bArr.length);
                x.i(str2, str3, objArr);
                if (bh.ov(str)) {
                    x.e("MicroMsg.JsApiHandler", "parameter error!!!");
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("deviceId", str);
                    b.bTq();
                    if (b.aZ(bArr) || (bArr != null && z2)) {
                        jSONObject2.put("base64BroadcastData", Base64.encodeToString(bArr, 2));
                    }
                    jSONArray.put(jSONObject2);
                    jSONObject.put("devices", jSONArray);
                    if (z) {
                        jSONObject.put("isCompleted", "1");
                    } else {
                        jSONObject.put("isCompleted", "0");
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.JsApiHandler", "Ex in onScanWXDeviceResult, %s", new Object[]{e.getMessage()});
                }
                try {
                    x.i("MicroMsg.JsApiHandler", "hakon onScanWXDeviceResult, %s", new Object[]{a.a("onScanWXDeviceResult", jSONObject, dVar.tGS, dVar.tGT)});
                    dVar.tGK.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + r0 + ")", null);
                } catch (Exception e2) {
                    x.w("MicroMsg.JsApiHandler", "onScanWXDeviceResult, %s", new Object[]{e2.getMessage()});
                }
                if (!z2) {
                    b.bTq().tBO = bArr;
                    return;
                }
                return;
            }
            x.e("MicroMsg.JsApiHandler", "onScanWXDeviceResult fail, not ready");
            return;
        }
        x.e("MicroMsg.WebViewUI", "hakon can not call onScanWXDeviceResult, %s, %s", new Object[]{this.tAx.tAv.tlx, this.tAx.tAv.juR});
    }
}
