package com.tencent.mm.compatible.d;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;

public final class m {
    static int gFD = 0;
    static String gFE = null;

    public static int yp() {
        int i;
        int i2 = 15;
        int i3 = n.yw() ? 7 : n.yx() ? 3 : 1;
        if (q.gFT.gFG && q.gFT.gFI == 0) {
            x.d("MicroMsg.CpuChecker", "disable armv6 by server ");
            i3 &= -3;
        }
        if (q.gFT.gFG && q.gFT.gFH == 0) {
            x.d("MicroMsg.CpuChecker", "disable armv7 by server ");
            i3 &= -5;
        }
        int yy = n.yy();
        if (yy > 16) {
            yy = 15;
        } else if (yy <= 0) {
            yy = 1;
        }
        int i4 = bh.getInt(yq(), 0) / 1000;
        if (yy > 4) {
            i = i4 * 4;
        } else if (yy > 2) {
            i = i4 * 2;
        } else if (yy > 1) {
            i = (i4 * 3) >> 1;
        } else {
            i = i4;
        }
        i /= 100;
        if (i > 30) {
            i = 30;
        } else if (i < 5) {
            i = 5;
        }
        if (i > 5 || yy < 4) {
            i2 = i;
        }
        i3 = ((i3 + (yy << 4)) << 8) + i2;
        gFD = i3;
        return i3;
    }

    public static String yq() {
        Closeable bufferedReader;
        Throwable th;
        String readLine;
        try {
            bufferedReader = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"));
            try {
                readLine = bufferedReader.readLine();
                if (readLine == null) {
                    throw new NullPointerException("null was returned while reading cpuinfo_max_freq.");
                }
                readLine = readLine.trim();
                bh.d(bufferedReader);
                return readLine;
            } catch (Throwable th2) {
                th = th2;
                try {
                    x.printErrStackTrace("MicroMsg.CpuChecker", th, "unexpected exception occurred.", new Object[0]);
                    readLine = "0";
                    bh.d(bufferedReader);
                    return readLine;
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
    }

    public static String yr() {
        Closeable bufferedReader;
        String readLine;
        Throwable th;
        try {
            bufferedReader = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq"));
            try {
                readLine = bufferedReader.readLine();
                if (readLine == null) {
                    throw new NullPointerException("null was returned while reading cpuinfo_min_freq.");
                }
                readLine = readLine.trim();
                bh.d(bufferedReader);
                return readLine;
            } catch (Throwable th2) {
                th = th2;
                try {
                    x.printErrStackTrace("MicroMsg.CpuChecker", th, "unexpected exception occurred.", new Object[0]);
                    readLine = "0";
                    bh.d(bufferedReader);
                    return readLine;
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
    }

    public static String ys() {
        String readLine;
        Throwable e;
        Closeable bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq"));
            try {
                readLine = bufferedReader.readLine();
                if (readLine == null) {
                    throw new NullPointerException("null was returned while reading scaling_cur_freq.");
                }
                readLine = readLine.trim();
                bh.d(bufferedReader);
                return readLine;
            } catch (Exception e2) {
                e = e2;
                try {
                    x.printErrStackTrace("MicroMsg.CpuChecker", e, "unexpected exception occurred.", new Object[0]);
                    readLine = "0";
                    bh.d(bufferedReader);
                    return readLine;
                } catch (Throwable th) {
                    e = th;
                    bh.d(bufferedReader);
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            bufferedReader = null;
            x.printErrStackTrace("MicroMsg.CpuChecker", e, "unexpected exception occurred.", new Object[0]);
            readLine = "0";
            bh.d(bufferedReader);
            return readLine;
        } catch (Throwable th2) {
            e = th2;
            bufferedReader = null;
            bh.d(bufferedReader);
            throw e;
        }
    }
}
