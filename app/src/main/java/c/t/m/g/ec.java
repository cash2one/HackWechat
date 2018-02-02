package c.t.m.g;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class ec {
    private static final byte[] a = new byte[]{(byte) 84, (byte) 101, (byte) 110, (byte) 99, (byte) 101, (byte) 110, (byte) 116, (byte) 76, (byte) 111, (byte) 99, (byte) 97, (byte) 116, (byte) 105, (byte) 111, (byte) 110, (byte) 49};
    private static final byte[] b = new byte[0];

    private static byte[] b(byte[] bArr, String str) {
        if (bArr == null || bArr.length == 0) {
            return b;
        }
        try {
            Key secretKeySpec = new SecretKeySpec(str.getBytes("UTF-8"), "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(1, secretKeySpec, new IvParameterSpec(a));
            if (instance == null) {
                return b;
            }
            return instance.doFinal(bArr);
        } catch (Throwable th) {
            return b;
        }
    }

    public static byte[] a(byte[] bArr, String str) {
        return b(bArr, str);
    }
}
