package com.tencent.mm.plugin.appbrand.jsapi.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.contact.d;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

@TargetApi(18)
public final class f extends a {
    private static final int CTRL_INDEX = 183;
    private static final String NAME = "getBLEDeviceCharacteristics";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        a.ks(151);
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiGetBLEDeviceCharacteristics", "getBLEDeviceCharacteristics data is null");
            jVar.E(i, e("fail:data is null", null));
            a.bG(153, JsApiMakeVoIPCall.CTRL_INDEX);
            return;
        }
        x.i("MicroMsg.JsApiGetBLEDeviceCharacteristics", "getBLEDeviceCharacteristics data %s", new Object[]{jSONObject.toString()});
        Map hashMap = new HashMap();
        if (com.tencent.mm.compatible.util.f.fN(18)) {
            x.e("MicroMsg.JsApiGetBLEDeviceCharacteristics", "API version is below 18!");
            hashMap.put("errCode", Integer.valueOf(10009));
            jVar.E(i, e("fail", hashMap));
            a.bG(153, 155);
            return;
        }
        String optString = jSONObject.optString("deviceId");
        String optString2 = jSONObject.optString("serviceId");
        x.i("MicroMsg.JsApiGetBLEDeviceCharacteristics", "try to get characteristics with deviceId : " + optString + ", and serviceId : " + optString2);
        if (b.jhB) {
            BluetoothManager bluetoothManager = (BluetoothManager) jVar.getContext().getSystemService("bluetooth");
            if (bluetoothManager == null) {
                x.e("MicroMsg.JsApiGetBLEDeviceCharacteristics", "bluetoothManager is null!");
                hashMap.put("errCode", Integer.valueOf(10001));
                jVar.E(i, e("fail", hashMap));
                a.bG(153, 157);
                return;
            }
            BluetoothAdapter adapter = bluetoothManager.getAdapter();
            if (adapter == null || !adapter.isEnabled()) {
                x.e("MicroMsg.JsApiGetBLEDeviceCharacteristics", "adapter is null or not enabled!");
                hashMap.put("errCode", Integer.valueOf(10001));
                jVar.E(i, e("fail", hashMap));
                a.bG(153, 158);
                return;
            }
            JSONArray jSONArray = (JSONArray) b.g(jVar).get(("key_bluetooth_gatt_service" + optString + optString2).hashCode(), null);
            if (jSONArray == null || jSONArray.length() <= 0) {
                x.e("MicroMsg.JsApiGetBLEDeviceCharacteristics", "not found services");
                hashMap.put("errCode", Integer.valueOf(10005));
                jVar.E(i, e("fail", hashMap));
                a.bG(153, JsApiGetBackgroundAudioState.CTRL_INDEX);
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("errMsg", getName() + ":ok");
                jSONObject2.put("characteristics", jSONArray);
                jSONObject2.put("errCode", 0);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.JsApiGetBLEDeviceCharacteristics", e, "", new Object[0]);
            }
            x.i("MicroMsg.JsApiGetBLEDeviceCharacteristics", "retJson %s", new Object[]{jSONObject2.toString()});
            jVar.E(i, jSONObject2.toString());
            a.kt(d.CTRL_INDEX);
            return;
        }
        x.e("MicroMsg.JsApiGetBLEDeviceCharacteristics", "bluetooth is not init!");
        hashMap.put("errCode", Integer.valueOf(10000));
        jVar.E(i, e("fail", hashMap));
        a.bG(153, 156);
    }
}
