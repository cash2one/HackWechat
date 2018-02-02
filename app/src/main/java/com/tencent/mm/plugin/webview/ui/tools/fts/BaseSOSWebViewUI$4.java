package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.34;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

class BaseSOSWebViewUI$4 implements Runnable {
    final /* synthetic */ String jLQ;
    final /* synthetic */ BaseSOSWebViewUI tCm;

    BaseSOSWebViewUI$4(BaseSOSWebViewUI baseSOSWebViewUI, String str) {
        this.tCm = baseSOSWebViewUI;
        this.jLQ = str;
    }

    public final void run() {
        if (BaseSOSWebViewUI.t(this.tCm) != null) {
            d u = BaseSOSWebViewUI.u(this.tCm);
            String str = this.jLQ;
            if (u.tGQ) {
                x.i("MicroMsg.JsApiHandler", "onSearchHistoryReady success, ready");
                try {
                    ag.y(new 34(u, a.a("onSearchHistoryReady", new JSONObject(str), u.tGS, u.tGT)));
                    return;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.JsApiHandler", e, "", new Object[0]);
                    return;
                }
            }
            x.e("MicroMsg.JsApiHandler", "onSearchHistoryReady fail, not ready");
        }
    }
}
