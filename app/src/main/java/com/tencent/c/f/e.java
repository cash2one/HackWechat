package com.tencent.c.f;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class e {
    public static byte[] bI(byte[] bArr) {
        byte[] bArr2 = null;
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            bArr2 = instance.digest();
        } catch (NoSuchAlgorithmException e) {
        } catch (Exception e2) {
        }
        return bArr2;
    }
}
