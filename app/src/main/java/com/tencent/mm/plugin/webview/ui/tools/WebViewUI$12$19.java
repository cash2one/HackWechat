package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.12;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass58;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i$a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

class WebViewUI$12$19 implements Runnable {
    final /* synthetic */ JSONArray tAM;
    final /* synthetic */ 12 tAx;

    WebViewUI$12$19(12 12, JSONArray jSONArray) {
        this.tAx = 12;
        this.tAM = jSONArray;
    }

    public final void run() {
        if (this.tAx.tAv.tlx != null) {
            d dVar = this.tAx.tAv.tlx;
            JSONArray jSONArray = this.tAM;
            if (jSONArray == null) {
                x.e("MicroMsg.JsApiHandler", "onGetMsgProofItems fail, not ready");
                return;
            }
            x.i("MicroMsg.JsApiHandler", "onGetMsgProofItems success, ready");
            Map hashMap = new HashMap();
            hashMap.put("msgs", jSONArray);
            ag.y(new AnonymousClass58(dVar, i$a.a("onGetMsgProofItems", hashMap, dVar.tGS, dVar.tGT)));
        }
    }
}
