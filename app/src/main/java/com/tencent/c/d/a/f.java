package com.tencent.c.d.a;

import com.tencent.c.d.b.a;
import com.tencent.c.d.b.c;
import com.tencent.c.f.h;
import java.io.File;

public final class f {
    private static boolean N(File file) {
        try {
            if ((c.aaT(file.getAbsolutePath()) & 2048) > 0) {
                return true;
            }
            return false;
        } catch (Throwable e) {
            h.k(e);
            return false;
        }
    }

    public static boolean cDt() {
        if (com.tencent.c.d.b.f.cDv()) {
            h.aaW("SetuidBitChecker : SELinux is enforcing");
            return false;
        }
        try {
            boolean z;
            File[] listFiles;
            String str = new String(a.aaS("/proc/mounts"));
            h.aaX("SetuidBitChecker mounts : " + str);
            for (String str2 : str.split("\n")) {
                if (str2.contains(" /system ")) {
                    if (str2.contains(",nosuid")) {
                        h.aaW("SetuidBitChecker : nosuid found");
                        z = true;
                        if (!z) {
                            return false;
                        }
                        if (c.isAvailable()) {
                            listFiles = new File("/system/bin").listFiles();
                            if (listFiles != null) {
                                while (r2 < r4) {
                                    if ("run-as".equals(r5.getName()) || !N(r5)) {
                                    } else {
                                        h.aaW("SetuidBitChecker s-bit found : " + r5.getAbsolutePath());
                                        return true;
                                    }
                                }
                            }
                            listFiles = new File("/system/xbin").listFiles();
                            if (listFiles != null) {
                                for (File file : listFiles) {
                                    if (N(file)) {
                                        h.aaW("SetuidBitChecker s-bit found : " + file.getAbsolutePath());
                                        return true;
                                    }
                                }
                            }
                            h.aaW("SetuidBitChecker s-bit not found");
                            return false;
                        }
                        h.aaW("SetuidBitChecker : OsUtil isn't available");
                        return false;
                    }
                    z = false;
                    if (!z) {
                        return false;
                    }
                    if (c.isAvailable()) {
                        listFiles = new File("/system/bin").listFiles();
                        if (listFiles != null) {
                            for (File file2 : listFiles) {
                                if ("run-as".equals(file2.getName())) {
                                }
                            }
                        }
                        listFiles = new File("/system/xbin").listFiles();
                        if (listFiles != null) {
                            while (r2 < r4) {
                                if (N(file2)) {
                                } else {
                                    h.aaW("SetuidBitChecker s-bit found : " + file2.getAbsolutePath());
                                    return true;
                                }
                            }
                        }
                        h.aaW("SetuidBitChecker s-bit not found");
                        return false;
                    }
                    h.aaW("SetuidBitChecker : OsUtil isn't available");
                    return false;
                }
            }
            z = false;
            if (!z) {
                return false;
            }
            if (c.isAvailable()) {
                h.aaW("SetuidBitChecker : OsUtil isn't available");
                return false;
            }
            listFiles = new File("/system/bin").listFiles();
            if (listFiles != null) {
                for (File file22 : listFiles) {
                    if ("run-as".equals(file22.getName())) {
                    }
                }
            }
            listFiles = new File("/system/xbin").listFiles();
            if (listFiles != null) {
                for (File file222 : listFiles) {
                    if (N(file222)) {
                        h.aaW("SetuidBitChecker s-bit found : " + file222.getAbsolutePath());
                        return true;
                    }
                }
            }
            h.aaW("SetuidBitChecker s-bit not found");
            return false;
        } catch (Throwable e) {
            h.k(e);
            return false;
        }
    }
}
