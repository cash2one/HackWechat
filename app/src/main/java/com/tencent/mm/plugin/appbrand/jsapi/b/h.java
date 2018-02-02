package com.tencent.mm.plugin.appbrand.jsapi.b;

import android.bluetooth.BluetoothAdapter;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.FileUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class h extends a {
    private static final int CTRL_INDEX = 175;
    private static final String NAME = "getBluetoothAdapterState";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        boolean z = true;
        a.ks(126);
        x.i("MicroMsg.JsApiGetBluetoothAdapterState", "getBluetoothAdapterState!");
        Map hashMap = new HashMap();
        if (f.fN(18)) {
            x.e("MicroMsg.JsApiGetBluetoothAdapterState", "API version is below 18!");
            hashMap.put("errCode", Integer.valueOf(10009));
            jVar.E(i, e("fail", hashMap));
            a.bG(FileUtils.S_IWUSR, 129);
        } else if (b.jhB) {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter == null) {
                hashMap.put("available", Boolean.valueOf(false));
                hashMap.put("discovering", Boolean.valueOf(false));
                jVar.E(i, e("ok", hashMap));
                a.kt(127);
                return;
            }
            boolean z2 = defaultAdapter.isEnabled();
            if (!defaultAdapter.isDiscovering()) {
                z = false;
            }
            x.i("MicroMsg.JsApiGetBluetoothAdapterState", "availableState : " + z2 + ",discoveringState : " + z);
            hashMap.put("available", Boolean.valueOf(z2));
            hashMap.put("discovering", Boolean.valueOf(z));
            jVar.E(i, e("ok", hashMap));
            a.kt(127);
        } else {
            x.e("MicroMsg.JsApiGetBluetoothAdapterState", "bluetooth is not init!");
            hashMap.put("errCode", Integer.valueOf(10000));
            jVar.E(i, e("fail", hashMap));
            a.bG(FileUtils.S_IWUSR, 130);
        }
    }
}
