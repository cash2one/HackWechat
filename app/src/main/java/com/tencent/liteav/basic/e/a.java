package com.tencent.liteav.basic.e;

import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import javax.crypto.Cipher;

public final class a {
    private static String a = "RSA";

    public static byte[] a(byte[] bArr, PrivateKey privateKey) {
        byte[] doFinal;
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(2, privateKey);
        int length = bArr.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; length - i > 0; i = instance.getBlockSize() + i) {
            if (length - i >= instance.getBlockSize()) {
                doFinal = instance.doFinal(bArr, i, instance.getBlockSize());
            } else {
                doFinal = instance.doFinal(bArr, i, length - i);
            }
            byteArrayOutputStream.write(doFinal);
        }
        doFinal = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return doFinal;
    }

    public static PrivateKey a(byte[] bArr) {
        return KeyFactory.getInstance(a).generatePrivate(new PKCS8EncodedKeySpec(bArr));
    }
}
