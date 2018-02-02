package com.tencent.mm.bq;

import java.io.UnsupportedEncodingException;

public final class b {
    public byte[] oz;

    private b() {
    }

    public b(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    public b(byte[] bArr, int i, int i2) {
        this.oz = new byte[i2];
        System.arraycopy(bArr, i, this.oz, 0, i2);
    }

    public static b s(byte[] bArr, int i, int i2) {
        return new b(bArr, i, i2);
    }

    public static b bc(byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        return new b(bArr);
    }

    public static b Tl(String str) {
        try {
            b bVar = new b();
            bVar.oz = str.getBytes("UTF-8");
            return bVar;
        } catch (Throwable e) {
            throw new RuntimeException("UTF-8 not supported?", e);
        }
    }

    public final b CD(int i) {
        Object obj = new byte[i];
        if (this.oz.length >= i) {
            System.arraycopy(this.oz, 0, obj, 0, i - 1);
            this.oz = obj;
        } else {
            System.arraycopy(this.oz, 0, obj, 0, this.oz.length);
            this.oz = obj;
        }
        return this;
    }

    public final byte[] toByteArray() {
        int length = this.oz.length;
        Object obj = new byte[length];
        System.arraycopy(this.oz, 0, obj, 0, length);
        return obj;
    }

    public final String cdp() {
        int i = 0;
        while (i < this.oz.length && this.oz[i] != (byte) 0) {
            try {
                i++;
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("UTF-8 not supported?");
            }
        }
        return new String(this.oz, 0, i, "UTF-8");
    }
}
