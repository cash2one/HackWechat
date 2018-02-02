package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.modelappbrand.w;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.40;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class b$7 extends w {
    final /* synthetic */ b tlF;

    b$7(b bVar) {
        this.tlF = bVar;
    }

    public final void iB(String str) {
        String str2;
        x.v("FTSSearchWidgetMgr", "on widget reload data, widgetId[%s]", new Object[]{str});
        String str3 = "";
        for (Entry entry : b.c(this.tlF).entrySet()) {
            b$b com_tencent_mm_plugin_webview_fts_b_b = (b$b) b.d(this.tlF).get(entry.getKey());
            if ((com_tencent_mm_plugin_webview_fts_b_b.fFm + "#" + com_tencent_mm_plugin_webview_fts_b_b.iSe).equals(str)) {
                str2 = (String) entry.getKey();
                break;
            }
        }
        str2 = str3;
        if (bh.ov(str2)) {
            x.e("FTSSearchWidgetMgr", "onWidgetReloadData widget cache key not found!");
            return;
        }
        d a = b.a(this.tlF);
        if (a.tGQ) {
            x.i("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadData success, ready");
            Map hashMap = new HashMap();
            hashMap.put("widgetId", str2);
            ag.y(new 40(a, a.a("onSearchWAWidgetReloadData", hashMap, a.tGS, a.tGT)));
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadData fail, not ready");
    }
}
