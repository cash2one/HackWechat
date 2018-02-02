package com.tencent.mm.plugin.g.a.b;

import android.bluetooth.BluetoothDevice;
import com.tencent.mm.plugin.g.a.b.b.2;

class b$2$1 implements Runnable {
    final /* synthetic */ byte[] kwT;
    final /* synthetic */ 2 kwU;
    final /* synthetic */ int kws;
    final /* synthetic */ BluetoothDevice kwv;

    b$2$1(2 2, BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        this.kwU = 2;
        this.kwv = bluetoothDevice;
        this.kws = i;
        this.kwT = bArr;
    }

    public final void run() {
        b.a(this.kwU.kwS, this.kwv, this.kws, this.kwT);
    }
}
