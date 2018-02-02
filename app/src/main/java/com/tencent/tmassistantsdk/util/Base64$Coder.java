package com.tencent.tmassistantsdk.util;

abstract class Base64$Coder {
    public int op;
    public byte[] output;

    public abstract int maxOutputSize(int i);

    public abstract boolean process(byte[] bArr, int i, int i2, boolean z);

    Base64$Coder() {
    }
}
