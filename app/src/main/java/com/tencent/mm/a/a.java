package com.tencent.mm.a;

import android.util.Base64;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.security.InvalidParameterException;
import java.security.Key;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class a {
    public static boolean f(String str, String str2, String str3) {
        return a(str, "AES/CBC/PKCS7Padding", str2, str3);
    }

    private static boolean a(String str, String str2, String str3, String str4) {
        Exception e;
        OutputStream outputStream;
        FileInputStream fileInputStream;
        Throwable th;
        FileOutputStream fileOutputStream;
        CipherOutputStream cipherOutputStream = null;
        if (bh.ov(str2)) {
            throw new InvalidParameterException("invalid cipherTransformation");
        }
        File file = new File(str3);
        File file2 = new File(str4);
        if (!file.exists() || !file.isFile()) {
            return false;
        }
        if (!file2.getParentFile().exists()) {
            file2.getParentFile().mkdirs();
        }
        file2.createNewFile();
        FileInputStream fileInputStream2;
        CipherOutputStream cipherOutputStream2;
        try {
            fileInputStream2 = new FileInputStream(file);
            try {
                OutputStream fileOutputStream2 = new FileOutputStream(file2);
                try {
                    byte[] decode = Base64.decode(str.getBytes(), 0);
                    Key secretKeySpec = new SecretKeySpec(decode, "AES");
                    Cipher instance = Cipher.getInstance(str2);
                    instance.init(2, secretKeySpec, new IvParameterSpec(Arrays.copyOf(decode, decode.length)));
                    cipherOutputStream2 = new CipherOutputStream(fileOutputStream2, instance);
                    try {
                        decode = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                        while (true) {
                            int read = fileInputStream2.read(decode);
                            if (read != -1) {
                                cipherOutputStream2.write(decode, 0, read);
                                cipherOutputStream2.flush();
                            } else {
                                cipherOutputStream2.close();
                                fileOutputStream2.close();
                                fileInputStream2.close();
                                return true;
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        outputStream = fileOutputStream2;
                        fileInputStream = fileInputStream2;
                        try {
                            throw e;
                        } catch (Throwable th2) {
                            th = th2;
                            fileInputStream2 = fileInputStream;
                            fileOutputStream = outputStream;
                            cipherOutputStream = cipherOutputStream2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        cipherOutputStream = cipherOutputStream2;
                        if (cipherOutputStream != null) {
                            cipherOutputStream.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    cipherOutputStream2 = null;
                    outputStream = fileOutputStream2;
                    fileInputStream = fileInputStream2;
                    throw e;
                } catch (Throwable th4) {
                    th = th4;
                    if (cipherOutputStream != null) {
                        cipherOutputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                cipherOutputStream2 = null;
                fileInputStream = fileInputStream2;
                throw e;
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = null;
                if (cipherOutputStream != null) {
                    cipherOutputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            cipherOutputStream2 = null;
            Object obj = null;
            throw e;
        } catch (Throwable th6) {
            th = th6;
            fileOutputStream = null;
            fileInputStream2 = null;
            if (cipherOutputStream != null) {
                cipherOutputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            throw th;
        }
    }

    private static byte[] bL(String str) {
        if (str.length() <= 0) {
            return null;
        }
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < str.length() / 2; i++) {
            bArr[i] = (byte) ((Integer.parseInt(str.substring(i * 2, (i * 2) + 1), 16) * 16) + Integer.parseInt(str.substring((i * 2) + 1, (i * 2) + 2), 16));
        }
        return bArr;
    }

    public static String u(String str, String str2) {
        if (bh.ov(str)) {
            return "";
        }
        try {
            return new String(e(bL(str), str2));
        } catch (Throwable e) {
            x.e("MicroMsg.AESUtils", bh.i(e));
            return str;
        }
    }

    private static byte[] e(byte[] bArr, String str) {
        try {
            Key secretKeySpec = new SecretKeySpec(str.getBytes(), "AES");
            Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
            instance.init(2, secretKeySpec);
            return instance.doFinal(bArr);
        } catch (Throwable e) {
            x.e("MicroMsg.AESUtils", bh.i(e));
            return null;
        }
    }
}
