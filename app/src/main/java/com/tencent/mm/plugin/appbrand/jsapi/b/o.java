package com.tencent.mm.plugin.appbrand.jsapi.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class o extends a {
    private static final int CTRL_INDEX = 177;
    private static final String NAME = "stopBluetoothDevicesDiscovery";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        a.ks(101);
        x.i("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "stopBluetoothDevicesDiscovery!");
        Map hashMap = new HashMap();
        if (f.fN(18)) {
            x.e("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "API version is below 18!");
            hashMap.put("errCode", Integer.valueOf(10009));
            jVar.E(i, e("fail", hashMap));
            a.bG(103, 105);
        } else if (b.jhB) {
            BluetoothManager bluetoothManager = (BluetoothManager) jVar.getContext().getSystemService("bluetooth");
            if (bluetoothManager == null) {
                x.e("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "bluetoothManager is null!");
                hashMap.put("isDiscovering", Boolean.valueOf(false));
                hashMap.put("errCode", Integer.valueOf(10001));
                jVar.E(i, e("fail", hashMap));
                a.bG(103, 107);
                return;
            }
            BluetoothAdapter adapter = bluetoothManager.getAdapter();
            if (adapter == null || !adapter.isEnabled()) {
                x.e("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "bluetoothAdapter is null or not enable!");
                hashMap.put("isDiscovering", Boolean.valueOf(false));
                hashMap.put("errCode", Integer.valueOf(10001));
                jVar.E(i, e("fail", hashMap));
                a.bG(103, 108);
                return;
            }
            n.a aVar = (n.a) b.g(jVar).get("key_bluetooth_le_scaner", null);
            if (aVar == null) {
                x.e("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "bluetoothLEScaner is null!");
                hashMap.put("isDiscovering", Boolean.valueOf(false));
                jVar.E(i, e("fail", hashMap));
                a.bG(103, 109);
                return;
            }
            adapter.stopLeScan(aVar);
            hashMap.put("isDiscovering", Boolean.valueOf(false));
            jVar.E(i, e("ok", hashMap));
            a aVar2 = new a((byte) 0);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("available", true);
                jSONObject2.put("discovering", false);
            } catch (JSONException e) {
                x.e("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "put JSON data error : %s", new Object[]{e});
            }
            x.i("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "OnBluetoothAdapterStateChange %s", new Object[]{jSONObject2.toString()});
            com.tencent.mm.plugin.appbrand.jsapi.f az = aVar2.az(jVar.mAppId, jVar.hashCode());
            az.mData = jSONObject2.toString();
            az.afs();
            a.kt(102);
        } else {
            x.e("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "bluetooth is not init!");
            hashMap.put("errCode", Integer.valueOf(10000));
            jVar.E(i, e("fail", hashMap));
            a.bG(103, 106);
        }
    }
}
