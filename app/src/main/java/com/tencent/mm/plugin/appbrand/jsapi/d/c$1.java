package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.d.a$a.a;
import com.tencent.mm.plugin.appbrand.jsapi.d.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class c$1 implements a {
    final /* synthetic */ j iZy;
    b jjP = new b((byte) 0);
    c$a jjQ = new c$a();
    final /* synthetic */ c jjR;

    c$1(c cVar, j jVar) {
        this.jjR = cVar;
        this.iZy = jVar;
    }

    public final void x(Map<String, JSONObject> map) {
        JSONArray jSONArray = new JSONArray();
        for (JSONObject jSONObject : map.values()) {
            if (jSONObject != null) {
                jSONArray.put(jSONObject);
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("beacons", jSONArray);
        } catch (JSONException e) {
            x.e("MicroMsg.JsApiStartBeaconDiscovery", "put res JSON data error : %s", new Object[]{e});
        }
        f az = this.jjP.az(this.iZy.mAppId, this.iZy.hashCode());
        az.mData = jSONObject2.toString();
        az.afs();
    }

    public final void cK(boolean z) {
        x.i("MicroMsg.JsApiStartBeaconDiscovery", "onBluetoothStateChange:%b", new Object[]{Boolean.valueOf(z)});
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("available", z);
            jSONObject.put("discovering", false);
        } catch (JSONException e) {
            x.e("MicroMsg.JsApiStartBeaconDiscovery", "put JSON data error : %s", new Object[]{e});
        }
        x.d("MicroMsg.JsApiStartBeaconDiscovery", "OnBeaconServiceChangedEvent %s", new Object[]{jSONObject.toString()});
        f az = this.jjQ.az(this.iZy.mAppId, this.iZy.hashCode());
        az.mData = jSONObject.toString();
        az.afs();
    }
}
