package com.tencent.mm.plugin.g.a.b;

import android.bluetooth.BluetoothGattCharacteristic;

public final class a {
    private int kwF = 20;
    private byte[] kwG = null;
    private int kwH = 0;
    private int kwI = 0;
    BluetoothGattCharacteristic kwJ = null;

    public final void setData(byte[] bArr) {
        if (bArr == null) {
            this.kwG = null;
            this.kwI = 0;
            this.kwH = 0;
            return;
        }
        this.kwG = new byte[bArr.length];
        System.arraycopy(bArr, 0, this.kwG, 0, bArr.length);
        this.kwI = bArr.length;
        this.kwH = 0;
    }

    public final byte[] ari() {
        int i = this.kwI - this.kwH;
        if (i == 0) {
            return null;
        }
        if (i >= this.kwF) {
            i = this.kwF;
        }
        Object obj = new byte[i];
        System.arraycopy(this.kwG, this.kwH, obj, 0, i);
        this.kwH = i + this.kwH;
        return obj;
    }
}
