package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.game.gamewebview.b.a.e;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.12;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.10;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class WebViewUI$12$50 implements Runnable {
    final /* synthetic */ 12 tAx;
    final /* synthetic */ String tBa;
    final /* synthetic */ int tBb;

    WebViewUI$12$50(12 12, String str, int i) {
        this.tAx = 12;
        this.tBa = str;
        this.tBb = i;
    }

    public final void run() {
        if (this.tAx.tAv.tlx != null) {
            d dVar = this.tAx.tAv.tlx;
            String str = this.tBa;
            int i = this.tBb;
            if (dVar.tGQ) {
                x.i("MicroMsg.JsApiHandler", "onMediaFileUploadProgress, local id : %s, percent : %d", new Object[]{str, Integer.valueOf(i)});
                Map hashMap = new HashMap();
                hashMap.put("localId", str);
                hashMap.put("percent", Integer.valueOf(i));
                ag.y(new 10(dVar, a.a(e.NAME, hashMap, dVar.tGS, dVar.tGT)));
                return;
            }
            x.e("MicroMsg.JsApiHandler", "onMediaFileUploadProgress fail, not ready");
        }
    }
}
