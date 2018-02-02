package com.tencent.mm.sdk.platformtools;

import android.os.Process;
import java.io.File;
import java.util.Scanner;

public final class bg {
    private static long xiA;
    private static long xiB;
    private static long xiC;
    private static long xiD;
    private static long xiE;
    private static long xiF;
    private static final File xiG;
    private static final File xiH;
    private static long xiq;
    private static long xir;
    private static long xis;
    private static long xit;
    private static long xiu;
    private static long xiv;
    private static long xiw;
    private static long xix;
    private static long xiy;
    private static long xiz;

    static {
        File file = null;
        File file2 = new File("/proc/" + Process.myPid() + "/net/dev");
        if (!file2.isFile()) {
            file2 = null;
        }
        xiG = file2;
        file2 = new File("/proc/net/xt_qtaguid/stats");
        if (file2.isFile()) {
            file = file2;
        }
        xiH = file;
    }

    public static long cgh() {
        return xiA > 0 ? xiA : 0;
    }

    public static long cgi() {
        return xiB > 0 ? xiB : 0;
    }

    public static long cgj() {
        return xiy > 0 ? xiy : 0;
    }

    public static long cgk() {
        return xiz > 0 ? xiz : 0;
    }

    public static long cgl() {
        return xiE > 0 ? xiE : 0;
    }

    public static long cgm() {
        return xiF > 0 ? xiF : 0;
    }

    public static long cgn() {
        return xiC > 0 ? xiC : 0;
    }

    public static long cgo() {
        return xiD > 0 ? xiD : 0;
    }

    public static void reset() {
        xiq = -1;
        xir = -1;
        xis = -1;
        xit = -1;
        xiv = -1;
        xiu = -1;
        xix = -1;
        xiw = -1;
        update();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void update() {
        Throwable e;
        long j = 0;
        long j2 = 0;
        Scanner scanner = null;
        Scanner scanner2;
        try {
            long j3;
            long j4;
            int i;
            long j5;
            if (xiG != null) {
                scanner2 = new Scanner(xiG);
                try {
                    scanner2.nextLine();
                    scanner2.nextLine();
                    j3 = 0;
                    j4 = 0;
                    while (scanner2.hasNext()) {
                        String[] split = scanner2.nextLine().split("[ :\t]+");
                        i = split[0].length() == 0 ? 1 : 0;
                        if (!split[i + 0].equals("lo")) {
                            if (split[i + 0].startsWith("rmnet") || split[i + 0].startsWith("ccmni")) {
                                j += Long.parseLong(split[i + 9]);
                                j2 += Long.parseLong(split[i + 1]);
                            } else {
                                j4 += Long.parseLong(split[i + 9]);
                                j3 += Long.parseLong(split[i + 1]);
                            }
                        }
                    }
                    scanner2.close();
                    scanner2 = null;
                    if (xiq < 0) {
                        xiq = j;
                        x.v("MicroMsg.SDK.TrafficStats", "fix loss newMobileTx %d", Long.valueOf(j));
                    }
                    if (xir < 0) {
                        xir = j2;
                        x.v("MicroMsg.SDK.TrafficStats", "fix loss newMobileRx %d", Long.valueOf(j2));
                    }
                    if (xis < 0) {
                        xis = j4;
                        x.v("MicroMsg.SDK.TrafficStats", "fix loss newWifiTx %d", Long.valueOf(j4));
                    }
                    if (xit < 0) {
                        xit = j3;
                        x.v("MicroMsg.SDK.TrafficStats", "fix loss newWifiRx %d", Long.valueOf(j3));
                    }
                    if (j3 - xit < 0) {
                        x.v("MicroMsg.SDK.TrafficStats", "minu %d", Long.valueOf(j3 - xit));
                    }
                    if (j4 - xis < 0) {
                        x.v("MicroMsg.SDK.TrafficStats", "minu %d", Long.valueOf(j4 - xis));
                    }
                    xiy = j >= xiq ? j - xiq : j;
                    if (j2 >= xir) {
                        j5 = j2 - xir;
                    } else {
                        j5 = j2;
                    }
                    xiz = j5;
                    if (j4 >= xis) {
                        j5 = j4 - xis;
                    } else {
                        j5 = j4;
                    }
                    xiA = j5;
                    if (j3 >= xit) {
                        j5 = j3 - xit;
                    } else {
                        j5 = j3;
                    }
                    xiB = j5;
                    xiq = j;
                    xir = j2;
                    xis = j4;
                    xit = j3;
                    scanner = null;
                } catch (Exception e2) {
                    e = e2;
                    scanner = scanner2;
                    try {
                        x.printErrStackTrace("MicroMsg.SDK.TrafficStats", e, "Failed retrieving TrafficStats.", new Object[0]);
                        if (scanner != null) {
                            scanner.close();
                        }
                        x.i("MicroMsg.SDK.TrafficStats", "current system traffic: wifi rx/tx=%d/%d, mobile rx/tx=%d/%d, wxWifi rx/tx=%d/%d wxMobile rx/tx=%d/%d", Long.valueOf(xiB), Long.valueOf(xiA), Long.valueOf(xiz), Long.valueOf(xiy), Long.valueOf(xiF), Long.valueOf(xiE), Long.valueOf(xiD), Long.valueOf(xiC));
                    } catch (Throwable th) {
                        e = th;
                        scanner2 = scanner;
                        if (scanner2 != null) {
                            scanner2.close();
                        }
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    if (scanner2 != null) {
                        scanner2.close();
                    }
                    throw e;
                }
            }
            if (xiH != null) {
                long j6;
                i = Process.myUid();
                scanner2 = new Scanner(xiH);
                scanner2.nextLine();
                j3 = 0;
                j4 = 0;
                long j7 = 0;
                long j8 = 0;
                while (scanner2.hasNext()) {
                    String[] split2 = scanner2.nextLine().split("[ :\\t]+");
                    if (Integer.parseInt(split2[3]) == i) {
                        String str = split2[1];
                        long parseLong = Long.parseLong(split2[5]);
                        j5 = Long.parseLong(split2[7]);
                        if (str.startsWith("rmnet") || str.startsWith("ccmni")) {
                            j7 += parseLong;
                            j8 += j5;
                        } else if (!str.equals("lo")) {
                            j3 += parseLong;
                            j4 += j5;
                        }
                    }
                }
                if (xiv < 0) {
                    xiv = j7;
                }
                if (xiu < 0) {
                    xiu = j8;
                }
                if (xix < 0) {
                    xix = j3;
                }
                if (xiw < 0) {
                    xiw = j4;
                }
                xiC = j8 >= xiu ? j8 - xiu : j8;
                if (j7 >= xiv) {
                    j6 = j7 - xiv;
                } else {
                    j6 = j7;
                }
                xiD = j6;
                if (j4 >= xiw) {
                    j6 = j4 - xiw;
                } else {
                    j6 = j4;
                }
                xiE = j6;
                if (j3 >= xix) {
                    j6 = j3 - xix;
                } else {
                    j6 = j3;
                }
                xiF = j6;
                xiu = j8;
                xiv = j7;
                xiw = j4;
                xix = j3;
            } else {
                scanner2 = scanner;
            }
            if (scanner2 != null) {
                scanner2.close();
            }
        } catch (Exception e3) {
            e = e3;
            x.printErrStackTrace("MicroMsg.SDK.TrafficStats", e, "Failed retrieving TrafficStats.", new Object[0]);
            if (scanner != null) {
                scanner.close();
            }
            x.i("MicroMsg.SDK.TrafficStats", "current system traffic: wifi rx/tx=%d/%d, mobile rx/tx=%d/%d, wxWifi rx/tx=%d/%d wxMobile rx/tx=%d/%d", Long.valueOf(xiB), Long.valueOf(xiA), Long.valueOf(xiz), Long.valueOf(xiy), Long.valueOf(xiF), Long.valueOf(xiE), Long.valueOf(xiD), Long.valueOf(xiC));
        } catch (Throwable th3) {
            e = th3;
            scanner2 = scanner;
            if (scanner2 != null) {
                scanner2.close();
            }
            throw e;
        }
        x.i("MicroMsg.SDK.TrafficStats", "current system traffic: wifi rx/tx=%d/%d, mobile rx/tx=%d/%d, wxWifi rx/tx=%d/%d wxMobile rx/tx=%d/%d", Long.valueOf(xiB), Long.valueOf(xiA), Long.valueOf(xiz), Long.valueOf(xiy), Long.valueOf(xiF), Long.valueOf(xiE), Long.valueOf(xiD), Long.valueOf(xiC));
    }
}
