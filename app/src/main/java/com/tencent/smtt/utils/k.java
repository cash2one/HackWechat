package com.tencent.smtt.utils;

import android.util.Base64;
import java.security.KeyFactory;
import java.security.Provider;
import java.security.Security;
import java.security.spec.X509EncodedKeySpec;
import java.util.Random;
import javax.crypto.Cipher;

public final class k {
    private static final char[] AaK = "0123456789abcdef".toCharArray();
    private static k AaL;
    private String AaM;
    private String AaN;
    String AaO = String.valueOf(new Random().nextInt(89999999) + 10000000);

    private k() {
        int nextInt = new Random().nextInt(89999999) + 10000000;
        this.AaM = this.AaO + String.valueOf(nextInt);
    }

    public static String abn(String str) {
        byte[] bytes = str.getBytes();
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("RSA/ECB/NoPadding");
        } catch (Exception e) {
            try {
                cFy();
                cipher = Cipher.getInstance("RSA/ECB/NoPadding");
            } catch (Exception e2) {
            }
        }
        cipher.init(1, KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MCwwDQYJKoZIhvcNAQEBBQADGwAwGAIRAMRB/Q0hTCD+XtnQhpQJefUCAwEAAQ==".getBytes(), 0))));
        return bytesToHex(cipher.doFinal(bytes));
    }

    private static String bytesToHex(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            cArr[i * 2] = AaK[i2 >>> 4];
            cArr[(i * 2) + 1] = AaK[i2 & 15];
        }
        return new String(cArr);
    }

    public static synchronized k cFx() {
        k kVar;
        synchronized (k.class) {
            if (AaL == null) {
                AaL = new k();
            }
            kVar = AaL;
        }
        return kVar;
    }

    private static void cFy() {
        Security.addProvider((Provider) Class.forName("com.android.org.bouncycastle.jce.provider.BouncyCastleProvider", true, ClassLoader.getSystemClassLoader()).newInstance());
    }

    public final String cFz() {
        if (this.AaN == null) {
            byte[] bytes = this.AaM.getBytes();
            Cipher cipher = null;
            try {
                cipher = Cipher.getInstance("RSA/ECB/NoPadding");
            } catch (Exception e) {
                try {
                    cFy();
                    cipher = Cipher.getInstance("RSA/ECB/NoPadding");
                } catch (Exception e2) {
                }
            }
            cipher.init(1, KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MCwwDQYJKoZIhvcNAQEBBQADGwAwGAIRAMRB/Q0hTCD+XtnQhpQJefUCAwEAAQ==".getBytes(), 0))));
            this.AaN = bytesToHex(cipher.doFinal(bytes));
        }
        return this.AaN;
    }
}
