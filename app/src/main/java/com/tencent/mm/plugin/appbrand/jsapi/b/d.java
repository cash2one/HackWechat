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
import org.json.JSONObject;

@TargetApi(18)
public final class d extends a {
    private static final int CTRL_INDEX = 174;
    private static final String NAME = "closeBluetoothAdapter";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.JsApiCloseBluetoothAdapter", "closeBluetoothAdapter!");
        a.ks(116);
        Map hashMap = new HashMap();
        if (f.fN(18)) {
            x.e("MicroMsg.JsApiCloseBluetoothAdapter", "API version is below 18!");
            hashMap.put("errCode", Integer.valueOf(10009));
            jVar.E(i, e("fail", hashMap));
            a.bG(118, 119);
        } else if (b.jhB) {
            BluetoothManager bluetoothManager = (BluetoothManager) jVar.getContext().getSystemService("bluetooth");
            if (bluetoothManager == null) {
                x.e("MicroMsg.JsApiCloseBluetoothAdapter", "bluetoothManager is null!");
                hashMap.put("errCode", Integer.valueOf(10001));
                jVar.E(i, e("fail", hashMap));
                a.bG(118, 121);
            } else if (jVar.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
                BluetoothAdapter adapter = bluetoothManager.getAdapter();
                if (adapter == null || !adapter.isEnabled()) {
                    x.e("MicroMsg.JsApiCloseBluetoothAdapter", "bluetoothAdapter is null!");
                    hashMap.put("errCode", Integer.valueOf(10001));
                    jVar.E(i, e("fail", hashMap));
                    a.bG(118, 123);
                    return;
                }
                if (adapter.isDiscovering()) {
                    adapter.cancelDiscovery();
                }
                if (l.jhN != null) {
                    x.i("MicroMsg.JsApiCloseBluetoothAdapter", "unregisterReceiver");
                    try {
                        jVar.getContext().unregisterReceiver(l.jhN);
                        l.jhN = null;
                    } catch (Exception e) {
                        x.e("MicroMsg.JsApiCloseBluetoothAdapter", "unregisterReceiver error!");
                    }
                }
                b.afT();
                b.afW();
                b.h(jVar);
                b.jhB = false;
                b.e(null);
                b.ku(0);
                x.i("MicroMsg.JsApiCloseBluetoothAdapter", "closeBluetoothAdapter end with success!");
                jVar.E(i, e("ok", null));
                a.kt(117);
            } else {
                x.e("MicroMsg.JsApiCloseBluetoothAdapter", "not support ble feature!");
                hashMap.put("errCode", Integer.valueOf(10001));
                jVar.E(i, e("fail", hashMap));
                a.bG(118, 122);
            }
        } else {
            x.e("MicroMsg.JsApiCloseBluetoothAdapter", "bluetooth is not init!");
            hashMap.put("errCode", Integer.valueOf(10000));
            jVar.E(i, e("fail", hashMap));
            a.bG(118, 120);
        }
    }
}
