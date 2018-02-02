package com.tencent.mm.aq.a.d;

import android.graphics.Bitmap;

public final class b {
    public String aBD;
    public Bitmap bitmap;
    public byte[] data;
    public int fqe;
    public int status;

    public b() {
        this.status = -1;
    }

    public b(Bitmap bitmap) {
        this.status = 0;
        this.fqe = 0;
        this.bitmap = bitmap;
    }

    public b(byte[] bArr, String str) {
        this.data = bArr;
        this.aBD = str;
    }

    public b(byte[] bArr, String str, byte b) {
        this.data = bArr;
        this.fqe = 2;
        this.aBD = str;
    }
}
