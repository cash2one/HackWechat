package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.ag.d.b;
import com.tencent.mm.ag.d.b.c;
import com.tencent.mm.ag.j;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter$d;
import org.json.JSONException;
import org.json.JSONObject;

class c$10 implements ChatFooter$d {
    final /* synthetic */ c yyQ;

    c$10(c cVar) {
        this.yyQ = cVar;
    }

    public final boolean ln(boolean z) {
        if (this.yyQ.kEC == null) {
            return false;
        }
        b bI = this.yyQ.kEC.bI(false);
        if (bI == null) {
            return false;
        }
        c LE = bI.LE();
        if (LE == null || LE.hpe == null || LE.hpe.isEmpty()) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(((j) LE.hpe.get(0)).value);
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = 1083;
            appBrandStatObject.fnp = this.yyQ.kEC.field_username;
            ((com.tencent.mm.plugin.appbrand.m.c) g.h(com.tencent.mm.plugin.appbrand.m.c.class)).a(this.yyQ.fhr.csq().getContext(), jSONObject.optString("userName"), null, 0, 0, jSONObject.optString("pagePath"), appBrandStatObject, this.yyQ.kEC.field_appId);
            return true;
        } catch (JSONException e) {
            return false;
        }
    }
}
