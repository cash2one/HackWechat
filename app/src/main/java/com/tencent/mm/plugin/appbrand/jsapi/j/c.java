package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import org.json.JSONArray;
import org.json.JSONObject;

public class c extends a {
    public static final int CTRL_INDEX = 63;
    public static final String NAME = "reportKeyValue";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        JSONArray optJSONArray = jSONObject.optJSONArray("dataArray");
        if (optJSONArray == null) {
            jVar.E(i, e("fail", null));
            return;
        }
        if (jVar.irP.iqx == null) {
            x.e("MicroMsg.JsApiReportKeyValue", "config is Null!");
            jVar.E(i, e("fail", null));
            return;
        }
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            try {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                int optInt = jSONObject2.optInt("key");
                String optString = jSONObject2.optString(DownloadSettingTable$Columns.VALUE);
                if (optInt > 0 && !bh.ov(optString)) {
                    g.pQN.h(optInt, new Object[]{jVar.mAppId, Integer.valueOf(r4.iOI.iGL), Integer.valueOf(r4.iOI.iGK + 1), optString});
                }
            } catch (Exception e) {
                x.e("MicroMsg.JsApiReportKeyValue", "AppBrandService parse report value failed : %s", new Object[]{e.getMessage()});
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
        if (pVar.irP.iqx == null) {
            x.e("MicroMsg.JsApiReportKeyValue", "config is Null!");
            pVar.E(i, e("fail", null));
            return;
        }
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            try {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                int optInt = jSONObject2.optInt("key");
                String optString = jSONObject2.optString(DownloadSettingTable$Columns.VALUE);
                if (optInt > 0 && !bh.ov(optString)) {
                    g.pQN.h(optInt, new Object[]{pVar.mAppId, Integer.valueOf(r4.iOI.iGL), Integer.valueOf(r4.iOI.iGK + 1), optString});
                }
            } catch (Exception e) {
                x.e("MicroMsg.JsApiReportKeyValue", "AppBrandPageView parse report value failed : %s", new Object[]{e.getMessage()});
            }
        }
        pVar.E(i, e("ok", null));
    }
}
