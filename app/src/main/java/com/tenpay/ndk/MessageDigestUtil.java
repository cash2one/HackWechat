package com.tenpay.ndk;

public class MessageDigestUtil {
    private native byte[] doSHA256(byte[] bArr);

    public static String bytesToHex(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(toHexString.toUpperCase());
        }
        return stringBuilder.toString();
    }

    public String getSHA256Hex(byte[] bArr) {
        String str = null;
        if (bArr != null) {
            try {
                byte[] doSHA256 = doSHA256(bArr);
                if (doSHA256 != null) {
                    str = bytesToHex(doSHA256);
                }
            } catch (Exception e) {
            }
        }
        return str;
    }
}
