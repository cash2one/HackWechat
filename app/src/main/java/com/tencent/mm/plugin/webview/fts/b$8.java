package com.tencent.mm.plugin.webview.fts;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.plugin.webview.fts.b.b;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.43;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i$a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class b$8 extends t {
    final /* synthetic */ b tlF;

    b$8(b bVar) {
        this.tlF = bVar;
    }

    public final void Y(String str, String str2) {
        String str3;
        x.v("FTSSearchWidgetMgr", "on widget data push, widgetId[%s], respData[%s]", new Object[]{str, str2});
        String str4 = "";
        for (Entry entry : b.c(this.tlF).entrySet()) {
            b bVar = (b) b.d(this.tlF).get(entry.getKey());
            if ((bVar.fFm + "#" + bVar.iSe).equals(str)) {
                str3 = (String) entry.getKey();
                break;
            }
        }
        str3 = str4;
        if (bh.ov(str3)) {
            x.e("FTSSearchWidgetMgr", "onWidgetDataPush widget cache key not found!");
            return;
        }
        d a = b.a(this.tlF);
        if (a.tGQ) {
            x.i("MicroMsg.JsApiHandler", "onSearchWAWidgetDataPush success, ready");
            Map hashMap = new HashMap();
            hashMap.put("widgetId", str3);
            hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, str2);
            ag.y(new 43(a, i$a.a("onSearchWAWidgetDataPush", hashMap, a.tGS, a.tGT)));
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onSearchWAWidgetDataPush fail, not ready");
    }
}
