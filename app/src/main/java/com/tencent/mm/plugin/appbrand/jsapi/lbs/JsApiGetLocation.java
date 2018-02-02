package com.tencent.mm.plugin.appbrand.jsapi.lbs;

import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import org.json.JSONObject;

public final class JsApiGetLocation extends a {
    public static final int CTRL_INDEX = 37;
    public static final String NAME = "getLocation";
    private static final HashSet<String> jkm;
    private static final HashSet<a> jkn = new HashSet();

    static {
        HashSet hashSet = new HashSet();
        jkm = hashSet;
        hashSet.add("gcj02");
        jkm.add("wgs84");
    }

    public final void a(j jVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString(DownloadSettingTable$Columns.TYPE, "wgs84");
        x.v("MicroMsg.JsApiGetLocation", "doGeoLocation, geoType = %s", new Object[]{optString});
        if (bh.ov(optString)) {
            optString = "wgs84";
        }
        if (bh.ov(optString) || jkm.contains(optString)) {
            p b = b(jVar);
            if (b == null) {
                jVar.E(i, e("fail", null));
                return;
            }
            LocationTask locationTask = new LocationTask();
            LocationTask.a(locationTask, jVar);
            LocationTask.a(locationTask, i);
            LocationTask.a(locationTask, this);
            LocationTask.a(locationTask, optString);
            LocationTask.a(locationTask, new WeakReference(b));
            LocationTask.a(locationTask, jSONObject.optBoolean("altitude", false));
            if (i(jVar)) {
                LocationTask.a(locationTask);
                return;
            } else {
                jVar.E(i, e("fail:system permission denied", null));
                return;
            }
        }
        x.e("MicroMsg.JsApiGetLocation", "doGeoLocation fail, unsupported type = %s", new Object[]{optString});
        jVar.E(i, e("fail:unsupported type", null));
    }
}
