package com.tencent.mm.plugin.normsg.utils;

public final class c {
    private static final char[] abZ = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String q(byte[] bArr, int i, int i2) {
        char[] cArr = new char[((i2 - i) * 2)];
        int i3 = 0;
        while (i < i2) {
            byte b = bArr[i];
            int i4 = i3 + 1;
            cArr[i3] = abZ[(b >>> 4) & 15];
            i3 = i4 + 1;
            cArr[i4] = abZ[b & 15];
            i++;
        }
        return new String(cArr);
    }

    public static String GG(String str) {
        StringBuilder stringBuilder = new StringBuilder(str.length());
        int i = 1;
        while (true) {
            int i2 = 0;
            try {
                i2 = str.charAt(i - 1) ^ str.charAt(i);
                if (i + 1 == str.length()) {
                    stringBuilder.append((char) i2);
                    return stringBuilder.toString();
                }
                stringBuilder.append((char) i2);
                i++;
            } catch (Throwable th) {
                return stringBuilder.toString();
            }
        }
    }
}
