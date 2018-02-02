package com.tencent.mm.plugin.appbrand.jsapi.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class l extends com.tencent.mm.plugin.appbrand.jsapi.a {
    private static final int CTRL_INDEX = 173;
    private static final String NAME = "openBluetoothAdapter";
    public static BroadcastReceiver jhN;

    private static class a extends f {
        private static final int CTRL_INDEX = 189;
        private static final String NAME = "onBluetoothAdapterStateChange";

        private a() {
        }
    }

    public final void a(final j jVar, JSONObject jSONObject, int i) {
        a.ks(0);
        x.i("MicroMsg.JsApiOpenBluetoothAdapter", "openBluetoothAdapter!");
        Map hashMap = new HashMap();
        if (com.tencent.mm.compatible.util.f.fN(18)) {
            x.e("MicroMsg.JsApiOpenBluetoothAdapter", "API version is below 18!");
            hashMap.put("errCode", Integer.valueOf(10009));
            jVar.E(i, e("fail", hashMap));
            a.bG(2, 4);
            return;
        }
        BluetoothManager bluetoothManager = (BluetoothManager) jVar.getContext().getSystemService("bluetooth");
        if (bluetoothManager == null) {
            x.e("MicroMsg.JsApiOpenBluetoothAdapter", "bluetoothManager is null!");
            jVar.E(i, e("fail", null));
            a.bG(2, 6);
        } else if (jVar.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
            BluetoothAdapter adapter = bluetoothManager.getAdapter();
            if (adapter == null) {
                x.e("MicroMsg.JsApiOpenBluetoothAdapter", "bluetoothAdapter is null!");
                jVar.E(i, e("fail", null));
                a.bG(2, 7);
                return;
            }
            if (jhN == null) {
                jhN = new BroadcastReceiver(this) {
                    final /* synthetic */ l jhO;

                    public final void onReceive(Context context, Intent intent) {
                        if (intent == null) {
                            x.i("MicroMsg.JsApiOpenBluetoothAdapter", "Receive intent failed");
                            return;
                        }
                        boolean z;
                        int i;
                        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                        byte b;
                        if (defaultAdapter != null) {
                            int state = defaultAdapter.getState();
                            if (state == 12) {
                                z = true;
                                i = 1;
                            } else if (state == 10) {
                                z = false;
                                i = 1;
                            } else {
                                z = false;
                                b = (byte) 0;
                            }
                            x.i("MicroMsg.JsApiOpenBluetoothAdapter", "bluetoothAdapter state: %s", new Object[]{Integer.valueOf(state)});
                        } else {
                            z = false;
                            b = (byte) 0;
                        }
                        if (i == 0) {
                            return;
                        }
                        if (b.jhB) {
                            a aVar = new a();
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("available", z);
                                jSONObject.put("discovering", false);
                            } catch (JSONException e) {
                                x.e("MicroMsg.JsApiOpenBluetoothAdapter", "put JSON data error : %s", new Object[]{e});
                            }
                            x.i("MicroMsg.JsApiOpenBluetoothAdapter", "OnBluetoothAdapterStateChange %s", new Object[]{jSONObject.toString()});
                            if (jVar != null) {
                                f az = aVar.az(jVar.mAppId, jVar.hashCode());
                                az.mData = jSONObject.toString();
                                az.afs();
                                return;
                            }
                            return;
                        }
                        x.e("MicroMsg.JsApiOpenBluetoothAdapter", "bluetooth is not init,return...");
                    }
                };
                x.i("MicroMsg.JsApiOpenBluetoothAdapter", "registerReceiver");
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
                jVar.getContext().registerReceiver(jhN, intentFilter);
            }
            c.a(jVar.mAppId, new 2(this, jVar));
            if (adapter.isEnabled()) {
                b.jhB = true;
                jVar.E(i, e("ok", null));
                a.kt(1);
                return;
            }
            x.e("MicroMsg.JsApiOpenBluetoothAdapter", "bluetoothAdapter not enabled!");
            b.jhB = true;
            hashMap.put("errCode", Integer.valueOf(10001));
            jVar.E(i, e("fail", hashMap));
            a.bG(2, 7);
        } else {
            x.e("MicroMsg.JsApiOpenBluetoothAdapter", "not support ble feature!");
            jVar.E(i, e("fail", null));
            a.bG(2, 8);
        }
    }
}
