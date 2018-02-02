package com.tencent.tinker.lib.f;

import com.tencent.tinker.c.b.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

class c$a {
    public String Aji;
    public String fqR;

    public c$a(String str, String str2) {
        this.fqR = str;
        this.Aji = str2;
    }

    public static c$a ab(File file) {
        String property;
        Object e;
        Throwable th;
        String str = null;
        Properties properties = new Properties();
        Object fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                properties.load(fileInputStream);
                property = properties.getProperty("md5");
                try {
                    str = properties.getProperty("times");
                    a.cy(fileInputStream);
                } catch (IOException e2) {
                    e = e2;
                    try {
                        a.e("Tinker.UpgradePatchRetry", "fail to readRetryProperty:" + e, new Object[0]);
                        a.cy(fileInputStream);
                        return new c$a(property, str);
                    } catch (Throwable th2) {
                        th = th2;
                        a.cy(fileInputStream);
                        throw th;
                    }
                }
            } catch (IOException e3) {
                IOException iOException = e3;
                property = str;
                a.e("Tinker.UpgradePatchRetry", "fail to readRetryProperty:" + e, new Object[0]);
                a.cy(fileInputStream);
                return new c$a(property, str);
            }
        } catch (IOException e32) {
            e = e32;
            fileInputStream = str;
            property = str;
            a.e("Tinker.UpgradePatchRetry", "fail to readRetryProperty:" + e, new Object[0]);
            a.cy(fileInputStream);
            return new c$a(property, str);
        } catch (Throwable th3) {
            fileInputStream = str;
            th = th3;
            a.cy(fileInputStream);
            throw th;
        }
        return new c$a(property, str);
    }

    public static void a(File file, c$a com_tencent_tinker_lib_f_c_a) {
        Object fileOutputStream;
        Throwable e;
        if (com_tencent_tinker_lib_f_c_a != null) {
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            Properties properties = new Properties();
            properties.put("md5", com_tencent_tinker_lib_f_c_a.fqR);
            properties.put("times", com_tencent_tinker_lib_f_c_a.Aji);
            try {
                fileOutputStream = new FileOutputStream(file, false);
                try {
                    properties.store(fileOutputStream, null);
                    a.cy(fileOutputStream);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        a.printErrStackTrace("Tinker.UpgradePatchRetry", e, "retry write property fail", new Object[0]);
                        a.cy(fileOutputStream);
                    } catch (Throwable th) {
                        e = th;
                        a.cy(fileOutputStream);
                        throw e;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
                a.printErrStackTrace("Tinker.UpgradePatchRetry", e, "retry write property fail", new Object[0]);
                a.cy(fileOutputStream);
            } catch (Throwable th2) {
                e = th2;
                fileOutputStream = null;
                a.cy(fileOutputStream);
                throw e;
            }
        }
    }
}
