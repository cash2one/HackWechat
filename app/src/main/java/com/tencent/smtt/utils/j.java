package com.tencent.smtt.utils;

import android.util.Base64;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

public final class j {
    private static String AaE = "";
    private static byte[] AaF = null;
    private static j AaI = null;
    private static String AaJ;
    protected static final char[] hexArray = "0123456789abcdef".toCharArray();
    private Cipher AaG = null;
    private Cipher AaH = null;

    private j() {
        AaJ = String.valueOf(new Random().nextInt(89999999) + 10000000) + String.valueOf(new Random().nextInt(89999999) + 10000000) + String.valueOf(new Random().nextInt(89999999) + 10000000);
        String str = "00000000";
        for (int i = 0; i < 12; i++) {
            str = str + String.valueOf(new Random().nextInt(89999999) + 10000000);
        }
        AaF = (str + AaJ).getBytes();
        this.AaG = Cipher.getInstance("RSA/ECB/NoPadding");
        this.AaG.init(1, KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDcEQ3TCNWPBqgIiY7WQ/IqTOTTV2w8aZ/GPm68FK0fAJBemZKtYR3Li46VJ+Hwnor7ZpQnblGWPFaLv5JoPqvavgB0GInuhm+T+syPs1mw0uPLWaqwvZsCfoaIvUuxy5xHJgmWARrK4/9pHyDxRlZte0PCIoR1ko5B8lVVH1X1dQIDAQAB".getBytes(), 0))));
        AaE = bytesToHex(this.AaG.doFinal(AaF));
        Key generateSecret = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(AaJ.getBytes()));
        this.AaH = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        this.AaH.init(1, generateSecret);
    }

    public static byte[] bM(byte[] bArr) {
        try {
            Key generateSecret = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(AaJ.getBytes()));
            Cipher instance = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            instance.init(2, generateSecret);
            return instance.doFinal(bArr);
        } catch (Exception e) {
            return null;
        }
    }

    public static String bytesToHex(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            cArr[i * 2] = hexArray[i2 >>> 4];
            cArr[(i * 2) + 1] = hexArray[i2 & 15];
        }
        return new String(cArr);
    }

    public static j cFu() {
        try {
            if (AaI == null) {
                AaI = new j();
            }
            return AaI;
        } catch (Exception e) {
            AaI = null;
            return null;
        }
    }

    public static String cFv() {
        return AaE;
    }

    public static String cFw() {
        return AaJ;
    }

    public static byte[] i(byte[] bArr, String str) {
        Key generateSecret = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(str.getBytes()));
        Cipher instance = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        instance.init(1, generateSecret);
        return instance.doFinal(bArr);
    }

    public final byte[] bL(byte[] bArr) {
        return this.AaH.doFinal(bArr);
    }
}
