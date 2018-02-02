package com.tencent.mm.plugin.appbrand.jsapi.b;

import com.tencent.mm.plugin.appbrand.jsapi.b.n.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

class n$a$1 implements a {
    final /* synthetic */ n.a jhV;

    n$a$1(n.a aVar) {
        this.jhV = aVar;
    }

    public final boolean uF() {
        c cVar = new c((byte) 0);
        Map afS = b.afS();
        JSONArray jSONArray = new JSONArray();
        for (String str : afS.keySet()) {
            jSONArray.put(afS.get(str));
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("devices", jSONArray);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.JsApiStartBluetoothDevicesDiscovery", e, "", new Object[0]);
        }
        if (jSONArray.length() > 0 && b.jhB) {
            f az = cVar.az(n.a.a(this.jhV).mAppId, n.a.a(this.jhV).hashCode());
            az.mData = jSONObject.toString();
            az.afs();
            b.afX();
            x.i("MicroMsg.JsApiStartBluetoothDevicesDiscovery", " run OnBluetoothDeviceFoundEvent in onTimerExpired!");
        }
        return true;
    }
}
