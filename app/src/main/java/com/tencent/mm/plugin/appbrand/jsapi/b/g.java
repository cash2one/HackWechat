package com.tencent.mm.plugin.appbrand.jsapi.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.contact.c;
import com.tencent.mm.plugin.appbrand.jsapi.map.b;
import com.tencent.mm.plugin.appbrand.jsapi.map.e;
import com.tencent.mm.plugin.appbrand.jsapi.map.h;
import com.tencent.mm.plugin.appbrand.jsapi.v;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.u;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class g extends a {
    private static final int CTRL_INDEX = 182;
    private static final String NAME = "getBLEDeviceServices";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        a.ks(h.CTRL_INDEX);
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiGetBLEDeviceServices", "JsApiGetBLEDeviceServices data is null");
            jVar.E(i, e("fail:data is null", null));
            a.bG(138, v.CTRL_INDEX);
            return;
        }
        x.i("MicroMsg.JsApiGetBLEDeviceServices", "getBLEDeviceServices data %s", new Object[]{jSONObject.toString()});
        Map hashMap = new HashMap();
        if (f.fN(18)) {
            x.e("MicroMsg.JsApiGetBLEDeviceServices", "API version is below 18!");
            hashMap.put("errCode", Integer.valueOf(10009));
            jVar.E(i, e("fail", hashMap));
            a.bG(138, b.CTRL_INDEX);
            return;
        }
        String optString = jSONObject.optString("deviceId");
        if (b.jhB) {
            BluetoothManager bluetoothManager = (BluetoothManager) jVar.getContext().getSystemService("bluetooth");
            if (bluetoothManager == null) {
                x.e("MicroMsg.JsApiGetBLEDeviceServices", "bluetoothManager is null!");
                hashMap.put("errCode", Integer.valueOf(10001));
                jVar.E(i, e("fail", hashMap));
                a.bG(138, 142);
                return;
            }
            BluetoothAdapter adapter = bluetoothManager.getAdapter();
            if (adapter == null || !adapter.isEnabled()) {
                x.e("MicroMsg.JsApiGetBLEDeviceServices", "adapter is null or not enabled!");
                hashMap.put("errCode", Integer.valueOf(10001));
                jVar.E(i, e("fail", hashMap));
                a.bG(138, c.CTRL_INDEX);
                return;
            }
            u.b g = b.g(jVar);
            x.i("MicroMsg.JsApiGetBLEDeviceServices", "try getBleDeviceServices with deviceId : " + optString);
            Map map = (Map) g.get("key_bluetooth_services_uuid" + optString, null);
            if (map == null || map.size() <= 0) {
                x.e("MicroMsg.JsApiGetBLEDeviceServices", "not found services");
                hashMap.put("errCode", Integer.valueOf(10004));
                jVar.E(i, e("fail", hashMap));
                a.bG(138, e.CTRL_INDEX);
                return;
            }
            JSONArray jSONArray = new JSONArray();
            for (Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                boolean c = bh.c((Boolean) entry.getValue());
                if (bh.ov(str)) {
                    x.e("MicroMsg.JsApiGetBLEDeviceServices", "get uuid is null");
                    break;
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("uuid", str);
                    jSONObject2.put("isPrimary", c);
                    jSONArray.put(jSONObject2);
                } catch (JSONException e) {
                    x.e("MicroMsg.JsApiGetBLEDeviceServices", "JSONException %s", new Object[]{e.getMessage()});
                }
            }
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("errMsg", getName() + ":ok");
                jSONObject3.put("services", jSONArray);
                jSONObject3.put("errCode", 0);
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.JsApiGetBLEDeviceServices", e2, "", new Object[0]);
            }
            x.i("MicroMsg.JsApiGetBLEDeviceServices", "retJson %s", new Object[]{jSONObject3.toString()});
            jVar.E(i, jSONObject3.toString());
            a.kt(137);
            return;
        }
        x.e("MicroMsg.JsApiGetBLEDeviceServices", "bluetooth is not init!");
        hashMap.put("errCode", Integer.valueOf(10000));
        jVar.E(i, e("fail", hashMap));
        a.bG(138, com.tencent.mm.plugin.appbrand.jsapi.map.j.CTRL_INDEX);
    }
}
