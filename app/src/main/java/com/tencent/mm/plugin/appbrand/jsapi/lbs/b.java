package com.tencent.mm.plugin.appbrand.jsapi.lbs;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.q.b.b$a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class b extends f implements com.tencent.mm.plugin.appbrand.q.b.b {
    private static final int CTRL_INDEX = 341;
    private static final String NAME = "onLocationChange";
    private final j jcM;

    b(j jVar) {
        this.jcM = jVar;
    }

    public final void a(double d, double d2, b$a com_tencent_mm_plugin_appbrand_q_b_b_a, double d3, double d4, double d5) {
        Map hashMap = new HashMap(7);
        hashMap.put("longitude", Double.valueOf(d2));
        hashMap.put("latitude", Double.valueOf(d));
        hashMap.put("speed", Double.valueOf(d3));
        hashMap.put("accuracy", Double.valueOf(d4));
        hashMap.put("altitude", Double.valueOf(d5));
        hashMap.put("verticalAccuracy", Float.valueOf(0.0f));
        hashMap.put("horizontalAccuracy", Double.valueOf(d4));
        x.v("MicroMsg.AppBrand.EventOnLocationChange", "onLocationChanged %s, %s, %s", new Object[]{this.jcM.mAppId, com_tencent_mm_plugin_appbrand_q_b_b_a.name(), new JSONObject(hashMap).toString()});
        synchronized (this) {
            f a = a(this.jcM);
            a.mData = r0;
            a.afs();
        }
    }
}
