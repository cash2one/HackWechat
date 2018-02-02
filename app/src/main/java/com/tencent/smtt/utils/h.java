package com.tencent.smtt.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class h {
    private static OutputStream zZj = null;

    public static synchronized void a(File file, String str, byte[] bArr, String str2) {
        byte[] bArr2 = null;
        synchronized (h.class) {
            byte[] fY = fY(str, str2);
            if (fY != null) {
                str2 = null;
                bArr2 = fY;
            }
            try {
                file.getParentFile().mkdirs();
                if (file.isFile() && file.exists() && file.length() > 2097152) {
                    file.delete();
                    file.createNewFile();
                }
                if (zZj == null) {
                    zZj = new BufferedOutputStream(new FileOutputStream(file, true));
                }
                if (str2 != null) {
                    zZj.write(str2.getBytes());
                } else {
                    zZj.write(bArr);
                    zZj.write(bArr2);
                    zZj.write(new byte[]{(byte) 10, (byte) 10});
                }
                if (zZj != null) {
                    zZj.flush();
                }
            } catch (Throwable th) {
            }
        }
    }

    public static String cFt() {
        return String.valueOf(System.currentTimeMillis());
    }

    private static byte[] fY(String str, String str2) {
        try {
            byte[] bytes = str2.getBytes("UTF-8");
            Cipher instance = Cipher.getInstance("RC4");
            instance.init(1, new SecretKeySpec(str.getBytes("UTF-8"), "RC4"));
            return instance.update(bytes);
        } catch (Throwable th) {
            new StringBuilder("encrypt exception:").append(th.getMessage());
            return null;
        }
    }

    private static byte[] fZ(String str, String str2) {
        try {
            byte[] bytes = str2.getBytes("UTF-8");
            Cipher instance = Cipher.getInstance("RC4");
            instance.init(1, new SecretKeySpec(str.getBytes("UTF-8"), "RC4"));
            return instance.update(bytes);
        } catch (Throwable th) {
            new StringBuilder("encrypt exception:").append(th.getMessage());
            return null;
        }
    }

    public static byte[] ga(String str, String str2) {
        try {
            Object fZ = fZ(str, str2);
            String format = String.format("%03d", new Object[]{Integer.valueOf(fZ.length)});
            Object obj = new byte[(fZ.length + 3)];
            obj[0] = (byte) format.charAt(0);
            obj[1] = (byte) format.charAt(1);
            obj[2] = (byte) format.charAt(2);
            System.arraycopy(fZ, 0, obj, 3, fZ.length);
            return obj;
        } catch (Exception e) {
            return null;
        }
    }
}
