package com.tencent.liteav.audio.impl;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothProfile.ServiceListener;
import java.util.List;

class b$2 implements ServiceListener {
    final /* synthetic */ b a;

    b$2(b bVar) {
        this.a = bVar;
    }

    public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
        if (i == 1) {
            b.a(this.a, (BluetoothHeadset) bluetoothProfile);
            List connectedDevices = b.b(this.a).getConnectedDevices();
            if (connectedDevices != null && connectedDevices.size() > 0) {
                b.a(this.a, (BluetoothDevice) connectedDevices.get(0));
            }
        }
    }

    public void onServiceDisconnected(int i) {
        if (i == 1) {
            b.a(this.a, null);
        }
    }
}
