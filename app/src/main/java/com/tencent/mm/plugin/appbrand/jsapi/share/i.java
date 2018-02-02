package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.menu.l;
import com.tencent.mm.plugin.appbrand.menu.m;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class i extends a {
    public static final int CTRL_INDEX = 210;
    public static final String NAME = "updateShareMenuShareTicket";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.JsApiUpdateShareMenuShareTicket", "invoke");
        p b = b(jVar);
        if (b != null) {
            l le = b.le(m.jAH);
            if (le == null) {
                jVar.E(i, e("fail:menu item do not exist", null));
                return;
            }
            le.iTl.o("enable_share_with_share_ticket", Boolean.valueOf(jSONObject.optBoolean("withShareTicket", false)));
            jVar.E(i, e("ok", null));
            x.i("MicroMsg.JsApiUpdateShareMenuShareTicket", "update share menu withShareTicket(%s)", new Object[]{Boolean.valueOf(r1)});
            return;
        }
        jVar.E(i, e("fail", null));
    }
}
