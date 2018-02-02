package com.tencent.mm.plugin.appbrand.jsapi.d;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.appbrand.jsapi.d.a.a;
import com.tencent.mm.sdk.platformtools.x;

class a$1 extends BroadcastReceiver {
    a$1() {
    }

    public final void onReceive(Context context, Intent intent) {
        boolean z = true;
        if (intent == null) {
            x.i("MicroMsg.BeaconManager", "Receive intent failed");
            return;
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null) {
            int state = defaultAdapter.getState();
            x.d("MicroMsg.BeaconManager", "state:%d", new Object[]{Integer.valueOf(state)});
            if (!(state == 12 || state == 11)) {
                z = (state == 10 || state == 13) ? false : false;
            }
            if ((a.jjI && !z) || (!a.jjI && z)) {
                for (a aVar : a.map.values()) {
                    if (aVar.agj() && !z) {
                        aVar.vo();
                    }
                    if (aVar.jjM != null) {
                        aVar.jjM.cK(z);
                    }
                }
            }
            a.jjI = z;
        }
    }
}
