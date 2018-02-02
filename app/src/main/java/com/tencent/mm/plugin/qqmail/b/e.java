package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import java.util.Map;
import java.util.Map.Entry;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public final class e {
    public static int pok = 100;
    private int gBI = pok;
    public String pol = null;

    public e(String str, int i) {
        x.i("Msg.Plugin.HttpRequestCache", "HttpRequestCache constructor, path = " + str + ", maxCount = " + i);
        this.pol = str;
        File file = new File(this.pol);
        if (!file.exists()) {
            file.mkdir();
        }
        if (i <= 0) {
            i = pok;
        }
        this.gBI = i;
    }

    public final byte[] k(String str, Map<String, String> map) {
        if (str == null || str.length() == 0) {
            x.e("Msg.Plugin.HttpRequestCache", "getCache, invalid argument");
            return null;
        }
        String l = l(str, map);
        byte[] readFromFile = readFromFile(this.pol + l);
        if (readFromFile == null) {
            x.i("Msg.Plugin.HttpRequestCache", "readFromFile fail, cipherText is null, read error or cache not exist");
            return null;
        }
        byte[] decrypt = decrypt(readFromFile, HG(l));
        if (decrypt != null) {
            return decrypt;
        }
        x.e("Msg.Plugin.HttpRequestCache", "decrypt fail, plaintText is null");
        return null;
    }

    public final boolean a(String str, Map<String, String> map, byte[] bArr) {
        if (str == null || str.length() == 0 || bArr == null || bArr.length == 0) {
            x.e("Msg.Plugin.HttpRequestCache", "setCache, invalid argument");
            return false;
        }
        bkg();
        String l = l(str, map);
        byte[] encrypt = encrypt(bArr, HG(l));
        if (encrypt != null) {
            return q(this.pol + l, encrypt);
        }
        x.e("Msg.Plugin.HttpRequestCache", "encrypt fail, cipherText is null");
        return false;
    }

    private static String l(String str, Map<String, String> map) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                String str2 = (String) entry.getKey();
                String str3 = (String) entry.getValue();
                stringBuffer.append(str2);
                stringBuffer.append(str3);
            }
        }
        return g.s(stringBuffer.toString().getBytes());
    }

    private static byte[] HG(String str) {
        return g.s(str.toString().getBytes()).substring(8, 16).getBytes();
    }

    public final void bkg() {
        int length;
        int i = 0;
        String[] list = new File(this.pol).list();
        if (list != null) {
            length = list.length;
        } else {
            length = 0;
        }
        if (length >= this.gBI) {
            String[] list2 = new File(this.pol).list();
            File file = null;
            int length2 = list2.length;
            while (i < length2) {
                file = new File(list2[i]);
                file.lastModified();
                i++;
            }
            if (file.exists()) {
                file.delete();
            }
        }
    }

    private static byte[] encrypt(byte[] bArr, byte[] bArr2) {
        try {
            Key generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(bArr2));
            Cipher instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
            instance.init(1, generateSecret, new IvParameterSpec("12345678".getBytes()));
            return instance.doFinal(bArr);
        } catch (Throwable e) {
            x.printErrStackTrace("Msg.Plugin.HttpRequestCache", e, "", new Object[0]);
            return null;
        }
    }

    private static byte[] decrypt(byte[] bArr, byte[] bArr2) {
        try {
            Key generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(bArr2));
            Cipher instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
            instance.init(2, generateSecret, new IvParameterSpec("12345678".getBytes()));
            return instance.doFinal(bArr);
        } catch (Throwable e) {
            x.printErrStackTrace("Msg.Plugin.HttpRequestCache", e, "", new Object[0]);
            return null;
        }
    }

    public static byte[] readFromFile(String str) {
        Throwable e;
        Throwable e2;
        FileInputStream fileInputStream;
        try {
            File file = new File(str);
            if (!file.exists()) {
                return null;
            }
            int length = (int) file.length();
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[length];
                if (fileInputStream.read(bArr) != length) {
                    try {
                        fileInputStream.close();
                        return null;
                    } catch (Throwable e3) {
                        x.printErrStackTrace("Msg.Plugin.HttpRequestCache", e3, "", new Object[0]);
                        return null;
                    }
                }
                try {
                    fileInputStream.close();
                } catch (Throwable e22) {
                    x.printErrStackTrace("Msg.Plugin.HttpRequestCache", e22, "", new Object[0]);
                }
                return bArr;
            } catch (Exception e4) {
                e3 = e4;
                try {
                    x.printErrStackTrace("Msg.Plugin.HttpRequestCache", e3, "", new Object[0]);
                    if (fileInputStream != null) {
                        return null;
                    }
                    try {
                        fileInputStream.close();
                        return null;
                    } catch (Throwable e32) {
                        x.printErrStackTrace("Msg.Plugin.HttpRequestCache", e32, "", new Object[0]);
                        return null;
                    }
                } catch (Throwable th) {
                    e22 = th;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable e322) {
                            x.printErrStackTrace("Msg.Plugin.HttpRequestCache", e322, "", new Object[0]);
                        }
                    }
                    throw e22;
                }
            }
        } catch (Exception e5) {
            e322 = e5;
            fileInputStream = null;
            x.printErrStackTrace("Msg.Plugin.HttpRequestCache", e322, "", new Object[0]);
            if (fileInputStream != null) {
                return null;
            }
            fileInputStream.close();
            return null;
        } catch (Throwable e3222) {
            fileInputStream = null;
            e22 = e3222;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw e22;
        }
    }

    public static boolean q(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        Throwable e;
        try {
            fileOutputStream = new FileOutputStream(str);
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.flush();
                try {
                    fileOutputStream.close();
                } catch (Throwable e2) {
                    x.printErrStackTrace("Msg.Plugin.HttpRequestCache", e2, "", new Object[0]);
                }
                return true;
            } catch (Exception e3) {
                e2 = e3;
                try {
                    x.printErrStackTrace("Msg.Plugin.HttpRequestCache", e2, "", new Object[0]);
                    if (fileOutputStream != null) {
                        return false;
                    }
                    try {
                        fileOutputStream.close();
                        return false;
                    } catch (Throwable e22) {
                        x.printErrStackTrace("Msg.Plugin.HttpRequestCache", e22, "", new Object[0]);
                        return false;
                    }
                } catch (Throwable th) {
                    e22 = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e4) {
                            x.printErrStackTrace("Msg.Plugin.HttpRequestCache", e4, "", new Object[0]);
                        }
                    }
                    throw e22;
                }
            }
        } catch (Exception e5) {
            e22 = e5;
            fileOutputStream = null;
            x.printErrStackTrace("Msg.Plugin.HttpRequestCache", e22, "", new Object[0]);
            if (fileOutputStream != null) {
                return false;
            }
            fileOutputStream.close();
            return false;
        } catch (Throwable th2) {
            e22 = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw e22;
        }
    }
}
