package com.tencent.mm.plugin.card.a;

import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import com.tencent.mm.plugin.card.a.i.a;
import com.tencent.mm.plugin.card.a.i.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class i$a$3 implements LeScanCallback {
    final /* synthetic */ a kJq;

    i$a$3(a aVar) {
        this.kJq = aVar;
    }

    public final void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        if (bluetoothDevice == null) {
            x.e("MicroMsg.CardLbsOrBluetooth", "device is null, return");
        } else if (this.kJq.kJj.kJb != null && !bh.ov(this.kJq.kJj.kJb.name)) {
            String ou = bh.ou(bluetoothDevice.getName());
            String address = bluetoothDevice.getAddress();
            if (ou.equals(this.kJq.kJj.kJb.name)) {
                x.i("MicroMsg.CardLbsOrBluetooth", "onLeScan for deviceId:%s, name:%s, rssi:%d", address, ou, Integer.valueOf(i));
                this.kJq.kJm.put(address, new b(address, i, ou, a.ag(bArr)));
                return;
            }
            x.d("MicroMsg.CardLbsOrBluetooth", "onLeScan for deviceId:%s, name:%s, rssi:%d", address, ou, Integer.valueOf(i));
        }
    }
}
