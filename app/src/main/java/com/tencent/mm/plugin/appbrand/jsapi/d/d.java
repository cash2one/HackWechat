package com.tencent.mm.plugin.appbrand.jsapi.d;

import android.annotation.TargetApi;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class d extends a {
    private static final int CTRL_INDEX = 222;
    private static final String NAME = "stopBeaconDiscovery";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.JsApiStopBeaconDiscovery", "stopBeaconDiscovery!");
        a.a sp = a.sp(jVar.mAppId);
        if (sp == null) {
            x.e("MicroMsg.JsApiStopBeaconDiscovery", "beaconWorker is null");
            Map hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(11004));
            jVar.E(i, e("fail", hashMap));
            return;
        }
        if (sp.vo()) {
            a.remove(jVar.mAppId);
            new HashMap().put("errCode", Integer.valueOf(0));
            jVar.E(i, e("ok", null));
        } else {
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(11004));
            jVar.E(i, e("fail", hashMap));
        }
        a aVar = new a((byte) 0);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("available", a.jjI);
            jSONObject2.put("discovering", false);
        } catch (JSONException e) {
            x.e("MicroMsg.JsApiStopBeaconDiscovery", "put JSON data error : %s", e);
        }
        x.i("MicroMsg.JsApiStopBeaconDiscovery", "OnBeaconServiceChangedEvent %s", jSONObject2.toString());
        f az = aVar.az(jVar.mAppId, jVar.hashCode());
        az.mData = jSONObject2.toString();
        az.afs();
    }
}
