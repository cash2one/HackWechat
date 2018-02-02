package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.appbrand.j;
import org.json.JSONObject;

public final class u extends a {
    public static final int CTRL_INDEX = 286;
    public static final String NAME = "chooseInvoiceTitle";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        Intent intent = new Intent();
        intent.putExtra("req_scene", 0);
        intent.putExtra("launch_from_appbrand", true);
        Context a = a(jVar);
        if (a == null) {
            jVar.E(i, e("fail", null));
            return;
        }
        a.jwN = new 1(this, jVar, i);
        d.a(a, "address", ".ui.InvoiceListUI", intent, hashCode() & 65535, false);
    }
}
