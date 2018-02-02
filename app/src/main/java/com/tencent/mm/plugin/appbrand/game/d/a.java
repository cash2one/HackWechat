package com.tencent.mm.plugin.appbrand.game.d;

import com.tencent.mm.plugin.appbrand.config.d;
import com.tencent.mm.plugin.appbrand.config.d.b;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public static final int CTRL_INDEX = 395;
    public static final String NAME = "setDeviceOrientation";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            jVar.E(i, e("fail", null));
            return;
        }
        b qC = d.qC(jSONObject.optString(DownloadSettingTable$Columns.VALUE, null));
        if (qC == null) {
            jVar.E(i, e("fail", null));
        } else if (jVar.irP == null || jVar.irP.iqt == null) {
            jVar.E(i, e("fail", null));
        } else {
            d$e.iNl.a(jVar.irP.iqt, qC, new 1(this, jVar, i));
        }
    }
}
