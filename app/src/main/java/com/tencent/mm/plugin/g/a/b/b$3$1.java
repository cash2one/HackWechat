package com.tencent.mm.plugin.g.a.b;

import android.bluetooth.BluetoothDevice;
import com.tencent.mm.plugin.g.a.b.b.3;

class b$3$1 implements Runnable {
    final /* synthetic */ byte[] kwT;
    final /* synthetic */ 3 kwV;
    final /* synthetic */ int kws;
    final /* synthetic */ BluetoothDevice kwv;

    b$3$1(3 3, BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        this.kwV = 3;
        this.kwv = bluetoothDevice;
        this.kws = i;
        this.kwT = bArr;
    }

    public final void run() {
        b.a(this.kwV.kwS, this.kwv, this.kws, this.kwT);
    }
}
