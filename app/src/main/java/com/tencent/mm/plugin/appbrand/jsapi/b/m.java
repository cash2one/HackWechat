package com.tencent.mm.plugin.appbrand.jsapi.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothManager;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.u$b;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@TargetApi(18)
public final class m extends a {
    private static final int CTRL_INDEX = 185;
    private static final String NAME = "readBLECharacteristicValue";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        a.ks(41);
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiReadBLECharacteristicValue", "JsApiReadBLECharacteristicValue data is null");
            jVar.E(i, e("fail:data is null", null));
            a.bG(43, 44);
            return;
        }
        x.i("MicroMsg.JsApiReadBLECharacteristicValue", "readBLECharacteristicValue data %s", new Object[]{jSONObject.toString()});
        Map hashMap = new HashMap();
        if (f.fN(18)) {
            x.e("MicroMsg.JsApiReadBLECharacteristicValue", "API version is below 18!");
            hashMap.put("errCode", Integer.valueOf(10009));
            jVar.E(i, e("fail", hashMap));
            a.bG(43, 45);
        } else if (b.jhB) {
            BluetoothManager bluetoothManager = (BluetoothManager) jVar.getContext().getSystemService("bluetooth");
            if (bluetoothManager == null) {
                x.e("MicroMsg.JsApiReadBLECharacteristicValue", "bluetoothManager is null!");
                hashMap.put("errCode", Integer.valueOf(10001));
                jVar.E(i, e("fail", hashMap));
                a.bG(43, 47);
                return;
            }
            BluetoothAdapter adapter = bluetoothManager.getAdapter();
            if (adapter == null || !adapter.isEnabled()) {
                x.e("MicroMsg.JsApiReadBLECharacteristicValue", "adapter is null or not enabled!");
                hashMap.put("errCode", Integer.valueOf(10001));
                jVar.E(i, e("fail", hashMap));
                a.bG(43, 48);
                return;
            }
            String optString = jSONObject.optString("deviceId");
            String optString2 = jSONObject.optString("serviceId");
            String optString3 = jSONObject.optString("characteristicId");
            u$b g = b.g(jVar);
            BluetoothGatt bluetoothGatt = (BluetoothGatt) g.get("key_bluetooth_gatt" + optString, null);
            if (bluetoothGatt == null) {
                x.e("MicroMsg.JsApiReadBLECharacteristicValue", "get bluetoothGatt failed, bluetoothGatt is null!");
                hashMap.put("errCode", Integer.valueOf(10001));
                jVar.E(i, e("fail", hashMap));
                a.bG(43, 49);
                return;
            }
            BluetoothGattCharacteristic bluetoothGattCharacteristic = (BluetoothGattCharacteristic) g.get(optString + optString2 + optString3, null);
            if (bluetoothGattCharacteristic == null) {
                x.e("MicroMsg.JsApiReadBLECharacteristicValue", "get characteristics failed !");
                hashMap.put("errCode", Integer.valueOf(10005));
                jVar.E(i, e("fail", hashMap));
                a.bG(43, 50);
            } else if (bluetoothGatt.readCharacteristic(bluetoothGattCharacteristic)) {
                hashMap.put("errCode", Integer.valueOf(0));
                jVar.E(i, e("ok", hashMap));
                a.kt(42);
            } else {
                hashMap.put("errCode", Integer.valueOf(10008));
                jVar.E(i, e("fail", hashMap));
            }
        } else {
            x.e("MicroMsg.JsApiReadBLECharacteristicValue", "bluetooth is not init!");
            hashMap.put("errCode", Integer.valueOf(10000));
            jVar.E(i, e("fail", hashMap));
            a.bG(43, 46);
        }
    }
}
