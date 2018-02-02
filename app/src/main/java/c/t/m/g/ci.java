package c.t.m.g;

import android.util.Base64;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class ci {
    private static final byte[] a = new byte[]{(byte) 84, (byte) 101, (byte) 110, (byte) 99, (byte) 101, (byte) 110, (byte) 116, (byte) 76, (byte) 111, (byte) 99, (byte) 97, (byte) 116, (byte) 105, (byte) 111, (byte) 110, (byte) 49};
    private static final byte[] b = new byte[0];

    private static String a(String str, String str2, int i) {
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException("wrong mode.");
        } else if (str == null || str.length() == 0) {
            return "";
        } else {
            byte[] bytes;
            if (i == 1) {
                try {
                    bytes = str.getBytes();
                } catch (Throwable th) {
                    return "";
                }
            } else if (i == 2) {
                bytes = Base64.decode(str.getBytes(), 2);
            } else {
                bytes = null;
            }
            if (bytes == null || bytes.length == 0) {
                return "";
            }
            bytes = a(bytes, str2, i);
            if (i == 1) {
                return Base64.encodeToString(bytes, 2);
            }
            if (i == 2) {
                return new String(bytes);
            }
            return null;
        }
    }

    private static byte[] a(byte[] bArr, String str, int i) {
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException("wrong mode.");
        } else if (bArr == null || bArr.length == 0) {
            return b;
        } else {
            try {
                Key secretKeySpec = new SecretKeySpec(str.getBytes("UTF-8"), "AES");
                Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
                instance.init(i, secretKeySpec, new IvParameterSpec(a));
                if (instance == null) {
                    return b;
                }
                return instance.doFinal(bArr);
            } catch (Throwable th) {
                return b;
            }
        }
    }

    public static String a(String str, String str2) {
        return a(str, str2, 1);
    }

    public static String b(String str, String str2) {
        return a(str, str2, 2);
    }
}
