package com.tencent.mm.a;

final class i {
    public byte[] fcL;
    public int fcM;

    public i() {
        this.fcM = 0;
        this.fcL = new byte[256];
    }

    public i(byte b) {
        this.fcM = 0;
        this.fcL = new byte[]{b};
    }

    public i(byte[] bArr) {
        this.fcM = 0;
        this.fcL = bArr;
    }
}
