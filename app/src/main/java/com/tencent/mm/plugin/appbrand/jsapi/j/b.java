package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import org.json.JSONArray;
import org.json.JSONObject;

public class b extends a {
    private static final int CTRL_INDEX = 64;
    private static final String NAME = "reportIDKey";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        JSONArray optJSONArray = jSONObject.optJSONArray("dataArray");
        if (optJSONArray == null) {
            jVar.E(i, e("fail", null));
            return;
        }
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            try {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                g.pQN.a((long) jSONObject2.optInt(SlookAirButtonFrequentContactAdapter.ID), (long) jSONObject2.optInt("key"), (long) jSONObject2.optInt(DownloadSettingTable$Columns.VALUE), false);
            } catch (Exception e) {
                x.e("MicroMsg.JsApiReportIDKey", "parse json failed : %s", new Object[]{e.getMessage()});
            }
        }
        jVar.E(i, e("ok", null));
    }

    public final void a(p pVar, JSONObject jSONObject, int i) {
        JSONArray optJSONArray = jSONObject.optJSONArray("dataArray");
        if (optJSONArray == null) {
            pVar.E(i, e("fail", null));
            return;
        }
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            try {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                g.pQN.a((long) jSONObject2.optInt(SlookAirButtonFrequentContactAdapter.ID), (long) jSONObject2.optInt("key"), (long) jSONObject2.optInt(DownloadSettingTable$Columns.VALUE), false);
            } catch (Exception e) {
                x.e("MicroMsg.JsApiReportIDKey", "parse json failed : %s", new Object[]{e.getMessage()});
            }
        }
        pVar.E(i, e("ok", null));
    }
}
