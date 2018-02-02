package com.tencent.mm.plugin.appbrand.dynamic.d;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.dynamic.d.a.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.u.b.b;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import org.json.JSONArray;
import org.json.JSONObject;

public final class j extends a {
    public j(int i) {
        super("reportIDKey", i);
    }

    protected final void a(com.tencent.mm.u.c.a aVar, JSONObject jSONObject, b.a<JSONObject> aVar2) {
        JSONArray optJSONArray = jSONObject.optJSONArray("dataArray");
        if (optJSONArray == null) {
            aVar2.aw(a(false, "dataArray is null", null));
            return;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            try {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                g.pQN.a((long) jSONObject2.optInt(SlookAirButtonFrequentContactAdapter.ID), (long) jSONObject2.optInt("key"), (long) jSONObject2.optInt(DownloadSettingTable$Columns.VALUE), false);
            } catch (Exception e) {
                x.e("MicroMsg.JsApiFunc_ReportIDKey", "parse json failed : %s", e.getMessage());
            }
        }
        aVar2.aw(a(true, "", null));
    }
}
