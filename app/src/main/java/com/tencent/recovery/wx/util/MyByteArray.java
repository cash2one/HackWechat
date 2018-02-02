package com.tencent.recovery.wx.util;

class MyByteArray {
    public byte[] fcL;
    public int fcM;

    public MyByteArray() {
        this.fcM = 0;
        this.fcL = new byte[256];
    }

    public MyByteArray(byte b) {
        this.fcM = 0;
        this.fcL = new byte[]{b};
    }

    public MyByteArray(byte[] bArr) {
        this.fcM = 0;
        this.fcL = bArr;
    }
}
