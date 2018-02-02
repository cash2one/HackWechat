package com.tencent.mm.plugin.g.a.b;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import com.tencent.mm.sdk.platformtools.x;

class d$1 extends BluetoothGattCallback {
    final /* synthetic */ d kxs;

    d$1(d dVar) {
        this.kxs = dVar;
    }

    public final void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
        x.i("MicroMsg.exdevice.BluetoothLESession", "------onConnectionStateChange------ connect newState = %d, op status = %d, mConnectState = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(this.kxs.kxq)});
        if (!this.kxs.mHandler.sendMessage(this.kxs.mHandler.obtainMessage(4, i2, 0))) {
            x.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(4)});
        }
    }

    public final void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
        x.i("MicroMsg.exdevice.BluetoothLESession", "------onServicesDiscovered------ status = %d", new Object[]{Integer.valueOf(i)});
        if (!this.kxs.mHandler.sendMessage(this.kxs.mHandler.obtainMessage(5, i, 0, bluetoothGatt))) {
            x.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(5)});
        }
    }

    public final void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        x.i("MicroMsg.exdevice.BluetoothLESession", "------onDescriptorWrite------ status = %d", new Object[]{Integer.valueOf(i)});
        if (!this.kxs.mHandler.sendMessage(this.kxs.mHandler.obtainMessage(6, i, 0, bluetoothGatt))) {
            x.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(6)});
        }
    }

    public final void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        x.i("MicroMsg.exdevice.BluetoothLESession", "------onDataReceive------");
        if (!this.kxs.mHandler.sendMessage(this.kxs.mHandler.obtainMessage(8, bluetoothGattCharacteristic.getValue()))) {
            x.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(8)});
        }
    }

    public final void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        x.i("MicroMsg.exdevice.BluetoothLESession", "------onCharacteristicRead------ status = %d", new Object[]{Integer.valueOf(i)});
    }

    public final void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        x.i("MicroMsg.exdevice.BluetoothLESession", "------onDataWriteCallback------ status = %d", new Object[]{Integer.valueOf(i)});
        if (!this.kxs.mHandler.sendMessage(this.kxs.mHandler.obtainMessage(7, i, 0))) {
            x.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(7)});
        }
    }
}
