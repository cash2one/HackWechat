package com.tencent.c.d.b;

import android.os.Build.VERSION;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;

public final class f {
    private static Boolean zTA = null;
    private static final Object zTB = new Object();

    public static boolean cDv() {
        boolean booleanValue;
        Closeable closeable = null;
        boolean z = false;
        synchronized (zTB) {
            if (zTA == null) {
                Boolean bool;
                if (VERSION.SDK_INT < 17 || !new File("/sys/fs/selinux/enforce").exists()) {
                    bool = null;
                } else {
                    Closeable fileInputStream;
                    try {
                        fileInputStream = new FileInputStream("/sys/fs/selinux/enforce");
                        try {
                            if (fileInputStream.read() == 49) {
                                z = true;
                            }
                            Boolean valueOf = Boolean.valueOf(z);
                            b.b(fileInputStream);
                            bool = valueOf;
                        } catch (Exception e) {
                            b.b(fileInputStream);
                            bool = null;
                            if (bool == null) {
                                bool = Boolean.valueOf(false);
                            }
                            zTA = bool;
                            booleanValue = zTA.booleanValue();
                            return booleanValue;
                        } catch (Throwable th) {
                            Throwable th2 = th;
                            closeable = fileInputStream;
                            Throwable th3 = th2;
                            b.b(closeable);
                            throw th3;
                        }
                    } catch (Exception e2) {
                        fileInputStream = null;
                        b.b(fileInputStream);
                        bool = null;
                        if (bool == null) {
                            bool = Boolean.valueOf(false);
                        }
                        zTA = bool;
                        booleanValue = zTA.booleanValue();
                        return booleanValue;
                    } catch (Throwable th4) {
                        th3 = th4;
                        b.b(closeable);
                        throw th3;
                    }
                }
                if (bool == null) {
                    bool = Boolean.valueOf(false);
                }
                zTA = bool;
            }
            booleanValue = zTA.booleanValue();
        }
        return booleanValue;
    }
}
