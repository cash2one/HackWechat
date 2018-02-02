package com.tencent.mm.plugin.nfc;

public final class b {
    public static String aD(byte[] bArr) {
        String str = "";
        if (!(bArr == null || bArr.length == 0)) {
            for (byte b : bArr) {
                int i;
                int i2 = b & 15;
                if (i2 < 10) {
                    i = 48;
                } else {
                    i = 55;
                }
                i2 += i;
                int i3 = (b & 240) >> 4;
                if (i3 < 10) {
                    i = 48;
                } else {
                    i = 55;
                }
                str = str + ((char) (i + i3)) + ((char) i2);
            }
        }
        return str;
    }
}
