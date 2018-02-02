package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.39;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class b$5 extends v {
    final /* synthetic */ b tlF;
    final /* synthetic */ String tlI;

    b$5(b bVar, String str) {
        this.tlF = bVar;
        this.tlI = str;
    }

    public final void iA(String str) {
        x.v("FTSSearchWidgetMgr", "on widget call %s ", "onOpenApp");
        d a = b.a(this.tlF);
        String str2 = this.tlI;
        if (a.tGQ) {
            x.i("MicroMsg.JsApiHandler", "onSearchWAWidgetOpenApp success, ready");
            Map hashMap = new HashMap();
            hashMap.put("widgetId", str2);
            hashMap.put("path", str);
            ag.y(new 39(a, a.a("onSearchWAWidgetOpenApp", hashMap, a.tGS, a.tGT)));
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onSearchWAWidgetOpenApp fail, not ready");
    }
}
