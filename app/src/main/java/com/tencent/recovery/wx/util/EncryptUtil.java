package com.tencent.recovery.wx.util;

import android.util.Base64;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.wcdb.FileUtils;
import java.io.ByteArrayOutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.spec.X509EncodedKeySpec;
import java.util.zip.Deflater;
import javax.crypto.Cipher;

public class EncryptUtil {
    public static byte[] h(byte[] bArr, String str) {
        byte[] doFinal;
        Key generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(2, generatePublic);
        int length = bArr.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        int i2 = 0;
        while (length - i2 > 0) {
            if (length - i2 > FileUtils.S_IWUSR) {
                doFinal = instance.doFinal(bArr, i2, FileUtils.S_IWUSR);
            } else {
                doFinal = instance.doFinal(bArr, i2, length - i2);
            }
            byteArrayOutputStream.write(doFinal, 0, doFinal.length);
            i2 = i + 1;
            int i3 = i2;
            i2 *= FileUtils.S_IWUSR;
            i = i3;
        }
        doFinal = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return doFinal;
    }

    public static final String s(byte[] bArr) {
        int i = 0;
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            byte[] digest = instance.digest();
            int length = digest.length;
            char[] cArr2 = new char[(length * 2)];
            int i2 = 0;
            while (i < length) {
                byte b = digest[i];
                int i3 = i2 + 1;
                cArr2[i2] = cArr[(b >>> 4) & 15];
                i2 = i3 + 1;
                cArr2[i3] = cArr[b & 15];
                i++;
            }
            return new String(cArr2);
        } catch (Exception e) {
            return null;
        }
    }

    public static int a(PByteArray pByteArray, byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return 2;
        }
        if (bArr.length < 0 || bArr2.length <= 0) {
            return 2;
        }
        int i;
        int length = 8 - (bArr.length % 8);
        byte[] bArr3 = new byte[(bArr.length + length)];
        for (i = 0; i < bArr.length; i++) {
            bArr3[i] = bArr[i];
        }
        for (i = 0; i < length; i++) {
            bArr3[bArr.length + i] = (byte) length;
        }
        pByteArray.value = new byte[((bArr.length + length) + 32)];
        if (MyDES.a(pByteArray.value, bArr3, (long) bArr3.length, bArr2.length, bArr2) == '\u0000') {
            return 11;
        }
        bArr3 = new byte[((bArr.length + length) + 8)];
        for (i = 0; i < bArr3.length; i++) {
            bArr3[i] = pByteArray.value[i];
        }
        pByteArray.value = bArr3;
        return 0;
    }

    public static byte[] q(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable e;
        Deflater deflater = new Deflater();
        deflater.reset();
        deflater.setInput(bArr);
        deflater.finish();
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            try {
                byte[] bArr2 = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                while (!deflater.finished()) {
                    byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
                }
                bArr = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable e2) {
                    RecoveryLog.printErrStackTrace("Recovery.EncryptUtil", e2, "", new Object[0]);
                }
            } catch (Exception e3) {
                e2 = e3;
                try {
                    RecoveryLog.printErrStackTrace("Recovery.EncryptUtil", e2, "", new Object[0]);
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable e22) {
                            RecoveryLog.printErrStackTrace("Recovery.EncryptUtil", e22, "", new Object[0]);
                        }
                    }
                    deflater.end();
                    return bArr;
                } catch (Throwable th) {
                    e22 = th;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable e4) {
                            RecoveryLog.printErrStackTrace("Recovery.EncryptUtil", e4, "", new Object[0]);
                        }
                    }
                    throw e22;
                }
            } catch (OutOfMemoryError e5) {
                throw new OutOfMemoryError("crash upload data length:" + bArr.length);
            }
        } catch (Exception e6) {
            e22 = e6;
            byteArrayOutputStream = null;
            RecoveryLog.printErrStackTrace("Recovery.EncryptUtil", e22, "", new Object[0]);
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            deflater.end();
            return bArr;
        } catch (OutOfMemoryError e7) {
            byteArrayOutputStream = null;
            throw new OutOfMemoryError("crash upload data length:" + bArr.length);
        } catch (Throwable th2) {
            e22 = th2;
            byteArrayOutputStream = null;
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            throw e22;
        }
        deflater.end();
        return bArr;
    }
}
