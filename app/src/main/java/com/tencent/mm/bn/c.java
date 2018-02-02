package com.tencent.mm.bn;

import android.os.StatFs;
import android.util.DisplayMetrics;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public final class c {
    private static String Tj(String str) {
        if (bh.ov(str)) {
            return "";
        }
        return str.replaceAll(" ", "").trim().replaceAll("kB", "").trim().replaceAll("\\t", "").trim();
    }

    public static String ccY() {
        Closeable bufferedReader;
        String replace;
        Throwable th;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/cpuinfo"), "UTF-8"));
            try {
                StringBuilder stringBuilder = new StringBuilder(256);
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (!bh.ov(readLine)) {
                        stringBuilder.append(Tj(readLine)).append(';');
                    }
                }
                replace = stringBuilder.toString().replace(',', '_');
                bh.d(bufferedReader);
            } catch (Throwable th2) {
                th = th2;
                try {
                    x.printErrStackTrace("MicroMsg.PostTaskHardwareInfo", th, "unexpected exception occurred.", new Object[0]);
                    replace = "";
                    bh.d(bufferedReader);
                    return replace;
                } catch (Throwable th3) {
                    th = th3;
                    bh.d(bufferedReader);
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            bh.d(bufferedReader);
            throw th;
        }
        return replace;
    }

    public static String ccZ() {
        Closeable bufferedReader;
        String replace;
        Throwable th;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/meminfo"), "UTF-8"));
            try {
                StringBuilder stringBuilder = new StringBuilder(256);
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (!bh.ov(readLine)) {
                        stringBuilder.append(Tj(readLine)).append(';');
                    }
                }
                replace = stringBuilder.toString().replace(',', '_');
                bh.d(bufferedReader);
            } catch (Throwable th2) {
                th = th2;
                try {
                    x.printErrStackTrace("MicroMsg.PostTaskHardwareInfo", th, "unexpected exception occurred.", new Object[0]);
                    replace = "";
                    bh.d(bufferedReader);
                    return replace;
                } catch (Throwable th3) {
                    th = th3;
                    bh.d(bufferedReader);
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            bh.d(bufferedReader);
            throw th;
        }
        return replace;
    }

    public static String cda() {
        String str = "";
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            displayMetrics = ac.getContext().getResources().getDisplayMetrics();
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            float f = displayMetrics.density;
            float f2 = displayMetrics.xdpi;
            float f3 = displayMetrics.ydpi;
            str = (((("" + "width:" + String.valueOf(i) + ";") + "height:" + String.valueOf(i2) + ";") + "density:" + String.valueOf(f) + ";") + "xd:" + String.valueOf(f2) + ";") + "yd:" + String.valueOf(f3) + ";";
        } catch (Throwable e) {
            x.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", bh.i(e));
        }
        return str.replace(",", "_");
    }

    public static String getRomInfo() {
        String str;
        String str2 = "";
        try {
            StatFs statFs = new StatFs(h.getDataDirectory().getPath());
            long blockSize = (long) statFs.getBlockSize();
            str2 = (str2 + "AvailableSizes:" + (((long) statFs.getAvailableBlocks()) * blockSize) + ";") + "FreeSizes:" + (((long) statFs.getFreeBlocks()) * blockSize) + ";";
            str = str2 + "AllSize:" + (((long) statFs.getBlockCount()) * blockSize) + ";";
        } catch (Throwable e) {
            Throwable th = e;
            str = str2;
            x.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", bh.i(th));
        }
        return str.replace(",", "_");
    }

    public static String cdb() {
        String str;
        String str2 = "";
        try {
            StatFs statFs = new StatFs(h.getExternalStorageDirectory().getPath());
            long blockSize = (long) statFs.getBlockSize();
            str2 = (str2 + "AvailableSizes:" + (((long) statFs.getAvailableBlocks()) * blockSize) + ";") + "FreeSizes:" + (((long) statFs.getFreeBlocks()) * blockSize) + ";";
            str = str2 + "AllSize:" + (((long) statFs.getBlockCount()) * blockSize) + ";";
        } catch (Throwable e) {
            Throwable th = e;
            str = str2;
            x.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", bh.i(th));
        }
        return str.replace(",", "_");
    }

    public static String cdc() {
        ar.Hg();
        return (String) com.tencent.mm.z.c.CU().get(71, null);
    }
}
