package com.tencent.mm.plugin.g.a.b;

import android.bluetooth.BluetoothDevice;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.g.a.b.g.a;
import com.tencent.mm.sdk.platformtools.x;

class b$3 implements a {
    final /* synthetic */ b kwS;

    b$3(b bVar) {
        this.kwS = bVar;
    }

    public final void c(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        x.d("MicroMsg.exdevice.BluetoothLEManager", "------onDiscover------ device Name = %s, mac = %s(%d)", new Object[]{bluetoothDevice.getName(), bluetoothDevice.getAddress(), Long.valueOf(b.zu(bluetoothDevice.getAddress()))});
        this.kwS.mHandler.post(new 1(this, bluetoothDevice, i, bArr));
    }

    public final void ne(int i) {
        x.i("MicroMsg.exdevice.BluetoothLEManager", "(API21)start ble scan failed, errorCode = %d", new Object[]{Integer.valueOf(i)});
        if (i != 1) {
            this.kwS.mHandler.post(new 2(this));
        }
    }
}
