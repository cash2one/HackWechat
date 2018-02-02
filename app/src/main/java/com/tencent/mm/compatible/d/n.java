package com.tencent.mm.compatible.d;

import android.os.Build.VERSION;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public final class n {
    private static Map<String, String> gFF = null;

    class a implements FileFilter {
        a() {
        }

        public final boolean accept(File file) {
            if (Pattern.matches("cpu[0-9]", file.getName())) {
                return true;
            }
            return false;
        }
    }

    public static Map<String, String> yt() {
        if (gFF == null) {
            gFF = yz();
        }
        return gFF;
    }

    public static String yu() {
        if (gFF == null) {
            gFF = yz();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(": ");
        stringBuilder.append(b(gFF, "Features"));
        stringBuilder.append(": ");
        stringBuilder.append(b(gFF, "Processor"));
        stringBuilder.append(": ");
        stringBuilder.append(b(gFF, "CPU architecture"));
        stringBuilder.append(": ");
        stringBuilder.append(b(gFF, "Hardware"));
        stringBuilder.append(": ");
        stringBuilder.append(b(gFF, "Serial"));
        return stringBuilder.toString();
    }

    public static boolean yv() {
        if (gFF == null) {
            gFF = yz();
        }
        if (gFF != null) {
            String b = b(gFF, "Features");
            if (b != null && b.contains("neon")) {
                return true;
            }
            if (b != null && b.contains("asimd")) {
                return true;
            }
        }
        return false;
    }

    public static boolean yw() {
        try {
            return (VERSION.SDK_INT >= 4) && yv();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Crash", e, "May cause dvmFindCatchBlock crash!", new Object[0]);
            throw ((IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e));
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean yx() {
        if (gFF == null) {
            gFF = yz();
        }
        if (gFF == null) {
            return false;
        }
        String b = b(gFF, "CPU architecture");
        x.d("CpuFeatures", "arch " + b);
        if (b == null) {
            return false;
        }
        try {
            if (b.length() <= 0) {
                return false;
            }
            int i = bh.getInt(eH(eG(b)), 0);
            x.d("CpuFeatures", "armarch " + i);
            if (i >= 6) {
                return true;
            }
            return false;
        } catch (Throwable e) {
            x.printErrStackTrace("CpuFeatures", e, "", new Object[0]);
            return false;
        }
    }

    public static int yy() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new a()).length;
        } catch (Exception e) {
            return 1;
        }
    }

    private static boolean f(char c) {
        if (c < '0' || c > '9') {
            return false;
        }
        return true;
    }

    private static String eG(String str) {
        if (str == null) {
            return str;
        }
        try {
            if (str.length() <= 0) {
                return str;
            }
            while (!f(str.charAt(0))) {
                if (str.length() == 1) {
                    return null;
                }
                str = str.substring(1);
            }
            return str;
        } catch (Throwable e) {
            x.printErrStackTrace("CpuFeatures", e, "", new Object[0]);
            return str;
        }
    }

    private static String eH(String str) {
        int i;
        int i2 = 0;
        while (true) {
            i = i2 + 1;
            try {
                if (!f(str.charAt(i2)) || str.length() <= i) {
                    i2 = i - 1;
                } else {
                    i2 = i;
                }
            } catch (Throwable e) {
                x.printErrStackTrace("CpuFeatures", e, "", new Object[0]);
            }
        }
        i2 = i - 1;
        if (str.length() > i2 + 1 && i2 > 0) {
            str = str.substring(0, i2);
        }
        return str;
    }

    private static String b(Map<String, String> map, String str) {
        return (String) map.get(str);
    }

    public static HashMap<String, String> yz() {
        Closeable bufferedReader;
        Throwable e;
        HashMap<String, String> hashMap = new HashMap();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/cpuinfo"), "UTF-8"));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    String[] split = readLine.split(":", 2);
                    if (split != null && split.length >= 2) {
                        String trim = split[0].trim();
                        readLine = split[1].trim();
                        if (hashMap.get(trim) == null) {
                            hashMap.put(trim, readLine);
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                }
            }
            bh.d(bufferedReader);
        } catch (IOException e3) {
            e = e3;
            bufferedReader = null;
            try {
                x.printErrStackTrace("CpuFeatures", e, "getCpu() failed.", new Object[0]);
                bh.d(bufferedReader);
                return hashMap;
            } catch (Throwable th) {
                e = th;
                bh.d(bufferedReader);
                throw e;
            }
        } catch (Throwable th2) {
            e = th2;
            bufferedReader = null;
            bh.d(bufferedReader);
            throw e;
        }
        return hashMap;
    }
}
