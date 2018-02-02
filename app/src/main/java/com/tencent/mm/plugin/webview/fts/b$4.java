package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.sdk.platformtools.x;

class b$4 extends u {
    final /* synthetic */ b tlF;
    final /* synthetic */ String tlI;

    b$4(b bVar, String str) {
        this.tlF = bVar;
        this.tlI = str;
    }

    public final void b(boolean z, String str, boolean z2) {
        x.v("FTSSearchWidgetMgr", "on widget call %s ", new Object[]{"onSearchWAWidgetOnTapCallback"});
        x.i("FTSSearchWidgetMgr", "on widget call %s , hasHandler %s, eventId %s,res %s", new Object[]{"onSearchWAWidgetOnTapCallback", Boolean.valueOf(z), str, Boolean.valueOf(z2)});
        d a = b.a(this.tlF);
        if (!z) {
            z2 = false;
        }
        a.a(str, z2, "", this.tlI);
    }
}
