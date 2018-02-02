package com.tencent.mm.plugin.g.a.b;

import android.bluetooth.BluetoothDevice;
import com.tencent.mm.plugin.g.a.b.g.a;

class g$2 implements Runnable {
    final /* synthetic */ byte[] kwT;
    final /* synthetic */ int kws;
    final /* synthetic */ BluetoothDevice kwv;
    final /* synthetic */ g kxS;

    g$2(g gVar, BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        this.kxS = gVar;
        this.kwv = bluetoothDevice;
        this.kws = i;
        this.kwT = bArr;
    }

    public final void run() {
        for (int i = 0; i < g.a(this.kxS).size(); i++) {
            ((a) g.a(this.kxS).get(i)).c(this.kwv, this.kws, this.kwT);
        }
    }
}
