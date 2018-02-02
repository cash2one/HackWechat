package com.tencent.mm.plugin.appbrand.jsapi.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothManager;
import android.location.LocationManager;
import android.os.Build.VERSION;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.u$b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class n extends a {
    private static final int CTRL_INDEX = 176;
    private static final String NAME = "startBluetoothDevicesDiscovery";
    boolean jhP;
    JSONObject jhQ;

    private static class c extends f {
        private static final int CTRL_INDEX = 190;
        private static final String NAME = "onBluetoothDeviceFound";

        private c() {
        }
    }

    public final void a(j jVar, JSONObject jSONObject, int i) {
        a.ks(11);
        if (jSONObject != null) {
            x.i("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "startBluetoothDevicesDiscovery data %s", new Object[]{jSONObject.toString()});
        }
        this.jhQ = jSONObject;
        Map hashMap = new HashMap();
        if (com.tencent.mm.compatible.util.f.fN(18)) {
            x.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "API version is below 18!");
            hashMap.put("errCode", Integer.valueOf(10009));
            jVar.E(i, e("fail", hashMap));
            a.bG(13, 15);
        } else if (b.jhB) {
            BluetoothManager bluetoothManager = (BluetoothManager) jVar.getContext().getSystemService("bluetooth");
            if (bluetoothManager == null) {
                x.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "bluetoothManager is null!");
                hashMap.put("isDiscovering", Boolean.valueOf(false));
                hashMap.put("errCode", Integer.valueOf(10001));
                jVar.E(i, e("fail", hashMap));
                a.bG(13, 17);
                return;
            }
            BluetoothAdapter adapter = bluetoothManager.getAdapter();
            if (adapter == null || !adapter.isEnabled()) {
                x.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "bluetoothAdapter is null!");
                hashMap.put("isDiscovering", Boolean.valueOf(false));
                hashMap.put("errCode", Integer.valueOf(10001));
                jVar.E(i, e("fail", hashMap));
                a.bG(13, 19);
                return;
            }
            if (!(VERSION.RELEASE.equals("6.0") || VERSION.RELEASE.equals("6.0.0") || VERSION.SDK_INT < 23)) {
                LocationManager locationManager = (LocationManager) ac.getContext().getSystemService("location");
                if (locationManager != null) {
                    boolean isProviderEnabled = locationManager.isProviderEnabled("gps");
                    x.i("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "isGPSEnable " + isProviderEnabled + ", isNetworkEnable" + locationManager.isProviderEnabled(TencentLocation.NETWORK_PROVIDER));
                }
            }
            u$b g = b.g(jVar);
            LeScanCallback leScanCallback = (a) g.get("key_bluetooth_le_scaner", null);
            if (leScanCallback == null) {
                x.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "bluetoothLEScaner is null!");
                leScanCallback = new a(this, jVar);
                g.o("key_bluetooth_le_scaner", leScanCallback);
            }
            if (adapter.isEnabled()) {
                boolean startLeScan;
                UUID[] uuidArr = null;
                if (this.jhQ.has("services")) {
                    List arrayList = new ArrayList();
                    try {
                        JSONArray jSONArray = new JSONArray(this.jhQ.optString("services"));
                        uuidArr = new UUID[jSONArray.length()];
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            String toUpperCase = jSONArray.getString(i2).toUpperCase();
                            arrayList.add(toUpperCase);
                            x.d("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "servicesUuid %s", new Object[]{toUpperCase});
                            uuidArr[i2] = UUID.fromString(toUpperCase);
                        }
                    } catch (JSONException e) {
                        x.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "get uuid error!");
                        hashMap.put("isDiscovering", Boolean.valueOf(false));
                        hashMap.put("errCode", Integer.valueOf(10004));
                        jVar.E(i, e("fail", hashMap));
                        return;
                    }
                }
                if (uuidArr == null || uuidArr.length <= 0) {
                    startLeScan = adapter.startLeScan(leScanCallback);
                } else {
                    startLeScan = adapter.startLeScan(uuidArr, leScanCallback);
                }
                if (startLeScan) {
                    hashMap.put("isDiscovering", Boolean.valueOf(true));
                    hashMap.put("errCode", Integer.valueOf(0));
                    jVar.E(i, e("ok", hashMap));
                    b bVar = new b((byte) 0);
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("available", true);
                        jSONObject2.put("discovering", true);
                    } catch (JSONException e2) {
                        x.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "put JSON data error : %s", new Object[]{e2});
                    }
                    x.i("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "OnBluetoothAdapterStateChange %s", new Object[]{jSONObject2.toString()});
                    f az = bVar.az(jVar.mAppId, jVar.hashCode());
                    az.mData = jSONObject2.toString();
                    az.afs();
                    a.kt(12);
                    return;
                }
                x.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "startLeScan fail...");
                hashMap.put("isDiscovering", Boolean.valueOf(false));
                hashMap.put("errCode", Integer.valueOf(10008));
                jVar.E(i, e("fail", hashMap));
                a.bG(13, 20);
                return;
            }
            hashMap.put("isDiscovering", Boolean.valueOf(false));
            hashMap.put("errCode", Integer.valueOf(10001));
            jVar.E(i, e("fail", hashMap));
            a.bG(13, 18);
        } else {
            x.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "bluetooth is not init!");
            hashMap.put("errCode", Integer.valueOf(10000));
            jVar.E(i, e("fail", hashMap));
            a.bG(13, 16);
        }
    }
}
