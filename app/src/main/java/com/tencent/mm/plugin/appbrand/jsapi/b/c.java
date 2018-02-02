package com.tencent.mm.plugin.appbrand.jsapi.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothManager;
import android.text.TextUtils;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.u.b;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@TargetApi(18)
public final class c extends a {
    private static final int CTRL_INDEX = 181;
    private static final String NAME = "closeBLEConnection";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        a.ks(91);
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiCloseBLEConnection", "JsApiCloseBLEConnection data is null");
            jVar.E(i, e("fail:data is null", null));
            a.bG(93, 94);
            return;
        }
        x.i("MicroMsg.JsApiCloseBLEConnection", "closeBLEConnection!");
        String optString = jSONObject.optString("deviceId");
        x.i("MicroMsg.JsApiCloseBLEConnection", "closeBLEConnection with deviceId : " + optString);
        Map hashMap = new HashMap();
        if (f.fN(18)) {
            x.e("MicroMsg.JsApiCloseBLEConnection", "API version is below 18!");
            hashMap.put("errCode", Integer.valueOf(10009));
            jVar.E(i, e("fail", hashMap));
            a.bG(93, 95);
        } else if (b.jhB) {
            BluetoothManager bluetoothManager = (BluetoothManager) jVar.getContext().getSystemService("bluetooth");
            if (bluetoothManager == null) {
                x.e("MicroMsg.JsApiCloseBLEConnection", "bluetoothManager is null!");
                hashMap.put("errCode", Integer.valueOf(10001));
                jVar.E(i, e("fail", hashMap));
                a.bG(93, 97);
                return;
            }
            BluetoothAdapter adapter = bluetoothManager.getAdapter();
            if (adapter == null || !adapter.isEnabled()) {
                x.e("MicroMsg.JsApiCloseBLEConnection", "adapter is null or not enabled!");
                hashMap.put("errCode", Integer.valueOf(10001));
                jVar.E(i, e("fail", hashMap));
                a.bG(93, 98);
                return;
            }
            b g = b.g(jVar);
            BluetoothGatt bluetoothGatt = (BluetoothGatt) g.get("key_bluetooth_gatt" + optString, null);
            if (bluetoothGatt == null) {
                x.e("MicroMsg.JsApiCloseBLEConnection", "get bluetoothGatt failed, bluetoothGatt is null!");
                hashMap.put("errCode", Integer.valueOf(10001));
                jVar.E(i, e("fail", hashMap));
                a.bG(93, 99);
                return;
            }
            x.i("MicroMsg.JsApiCloseBLEConnection", "close BluetoothGatt %s", new Object[]{bluetoothGatt.toString()});
            bluetoothGatt.disconnect();
            bluetoothGatt.close();
            CharSequence charSequence = "key_bluetooth_gatt" + optString;
            if (!TextUtils.isEmpty(charSequence)) {
                g.hfv.remove(charSequence);
            }
            hashMap.put("errCode", Integer.valueOf(0));
            jVar.E(i, e("ok", hashMap));
            a.kt(92);
        } else {
            x.e("MicroMsg.JsApiCloseBLEConnection", "bluetooth is not init!");
            hashMap.put("errCode", Integer.valueOf(10000));
            jVar.E(i, e("fail", hashMap));
            a.bG(93, 96);
        }
    }
}
