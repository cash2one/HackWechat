package com.google.android.gms.common;

import java.lang.ref.WeakReference;

abstract class j$bc extends j$a {
    private static final WeakReference<byte[]> aQs = new WeakReference(null);
    private WeakReference<byte[]> aQr = aQs;

    j$bc(byte[] bArr) {
        super(bArr);
    }

    final byte[] getBytes() {
        byte[] bArr;
        synchronized (this) {
            bArr = (byte[]) this.aQr.get();
            if (bArr == null) {
                bArr = pn();
                this.aQr = new WeakReference(bArr);
            }
        }
        return bArr;
    }

    protected abstract byte[] pn();
}
