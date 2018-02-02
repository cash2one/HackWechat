package com.tencent.mm.plugin.g.a.b;

import android.bluetooth.BluetoothDevice;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.g.a.b.a.c;
import com.tencent.mm.sdk.platformtools.x;

class e$1 implements c$a {
    final /* synthetic */ e kxy;

    e$1(e eVar) {
        this.kxy = eVar;
    }

    public final void c(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        long zu = b.zu(bluetoothDevice.getAddress());
        if (!this.kxy.kxv.contains(Long.valueOf(zu))) {
            x.d("MicroMsg.exdevice.BluetoothLESimpleManager", "------onDiscover------ device Name = %s, mac = %s(%d), scanRecord = %s", new Object[]{bluetoothDevice.getName(), bluetoothDevice.getAddress(), Long.valueOf(zu), b.ap(bArr)});
            this.kxy.kxv.add(Long.valueOf(zu));
            if (c.ae(bArr)) {
                this.kxy.kxu.a(bluetoothDevice.getAddress(), bluetoothDevice.getName(), i, bArr);
            }
        }
    }

    public final void arl() {
        x.d("MicroMsg.exdevice.BluetoothLESimpleManager", "------onDiscoverFinished------");
        if (this.kxy.kxu != null) {
            this.kxy.kxu.arl();
        } else {
            x.w("MicroMsg.exdevice.BluetoothLESimpleManager", "no SimpleBLEManagerCallback");
        }
        this.kxy.kxv.clear();
    }
}
