package com.tencent.mm.plugin.appbrand.dynamic.d;

import com.tencent.mm.plugin.appbrand.dynamic.d.a.a;
import com.tencent.mm.plugin.appbrand.dynamic.i;
import com.tencent.mm.plugin.appbrand.jsapi.j.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.u.b.b;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import org.json.JSONArray;
import org.json.JSONObject;

public final class k extends a {
    public k(int i) {
        super(c.NAME, i);
    }

    protected final void a(com.tencent.mm.u.c.a aVar, JSONObject jSONObject, b.a<JSONObject> aVar2) {
        if (i.ro(aVar.Cb().getString("__page_view_id", null)) == null) {
            aVar2.aw(a(false, "JsApi Framework Context is null", null));
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("dataArray");
        if (optJSONArray == null) {
            aVar2.aw(a(false, "dataArray is null", null));
            return;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            try {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                int optInt = jSONObject2.optInt("key");
                String optString = jSONObject2.optString(DownloadSettingTable$Columns.VALUE);
                if (optInt > 0 && !bh.ov(optString)) {
                    g.pQN.h(optInt, r3.getAppId(), Integer.valueOf(r3.acK()), Integer.valueOf(com.tencent.mm.plugin.appbrand.dynamic.k.a.jX(r3.acJ()) + 1), optString);
                }
            } catch (Exception e) {
                x.e("MicroMsg.JsApiFunc_ReportKeyValue", "parse report value failed : %s", e);
            }
        }
        aVar2.aw(a(true, "", null));
    }
}
