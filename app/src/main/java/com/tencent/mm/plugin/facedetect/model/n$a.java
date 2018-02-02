package com.tencent.mm.plugin.facedetect.model;

public class n$a {
    public static byte[] f(byte[] bArr, String str) {
        int i;
        int i2;
        int i3 = 0;
        byte[] bytes = str.getBytes();
        byte[] bArr2 = new byte[256];
        for (i = 0; i < 256; i++) {
            bArr2[i] = (byte) i;
        }
        if (bytes == null || bytes.length == 0) {
            bArr2 = null;
        } else {
            i2 = 0;
            int i4 = 0;
            for (i = 0; i < 256; i++) {
                i2 = (i2 + ((bytes[i4] & 255) + (bArr2[i] & 255))) & 255;
                byte b = bArr2[i];
                bArr2[i] = bArr2[i2];
                bArr2[i2] = b;
                i4 = (i4 + 1) % bytes.length;
            }
        }
        byte[] bArr3 = new byte[bArr.length];
        if (bArr2 != null) {
            i = 0;
            i2 = 0;
            while (i3 < bArr.length) {
                i2 = (i2 + 1) & 255;
                i = (i + (bArr2[i2] & 255)) & 255;
                byte b2 = bArr2[i2];
                bArr2[i2] = bArr2[i];
                bArr2[i] = b2;
                int i5 = ((bArr2[i2] & 255) + (bArr2[i] & 255)) & 255;
                bArr3[i3] = (byte) (bArr2[i5] ^ bArr[i3]);
                i3++;
            }
        }
        return bArr3;
    }
}
