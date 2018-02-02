package com.tencent.mm.plugin.g.a.a;

import android.bluetooth.BluetoothDevice;

class f$9 implements Runnable {
    final /* synthetic */ f kwp;
    final /* synthetic */ int kws;
    final /* synthetic */ e kwu;
    final /* synthetic */ BluetoothDevice kwv;

    f$9(f fVar, int i, BluetoothDevice bluetoothDevice, e eVar) {
        this.kwp = fVar;
        this.kws = i;
        this.kwv = bluetoothDevice;
        this.kwu = eVar;
    }

    public final void run() {
        f.d(this.kwp).a(this.kws, this.kwv.getAddress(), this.kwu);
    }
}
