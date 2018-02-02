package com.tencent.mm.blink;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class a {
    private static long gwZ;
    public static final int[] gxa = new int[]{0, 1, 2};
    public static final int[] gxb = new int[]{3, 13, 23};
    public static final int[] gxc = new int[]{4, 14, 24};
    public static final int[] gxd = new int[]{5, 15, 25};
    public static final int[] gxe = new int[]{6, 16, 26};
    public static final int[] gxf = new int[]{7, 17, 27};
    public static final int[] gxg = new int[]{8, 18, 28};
    public static final int[] gxh = new int[]{9, 19, 29};
    public static final int[] gxi = new int[]{63, 69, 75};
    public static final int[] gxj = new int[]{64, 70, 76};
    public static final int[] gxk = new int[]{65, 71, 77};
    public static final int[] gxl = new int[]{66, 72, 78};
    private static final ArrayList<long[]> gxm = new ArrayList();
    private static long gxn = 0;
    private static boolean gxo = false;
    private static long gxp = 0;
    private static long gxq = 0;
    private static byte gxr = (byte) 0;

    public static void at(long j) {
        gwZ = j;
    }

    public static void h(String str, long j) {
        long nanoTime = System.nanoTime() - j;
        x.i("Blink-LOG", "since the %s : %s", str, Long.valueOf(nanoTime));
    }

    public static void ec(String str) {
        long currentTimeMillis = System.currentTimeMillis() - gwZ;
        x.i("Blink-LOG", "since startup %s : %s", str, Long.valueOf(currentTimeMillis));
        String.format("since startup %s : %s", new Object[]{str, Long.valueOf(currentTimeMillis)});
    }

    public static void i(long j, long j2) {
        gxm.add(new long[]{709, j, j2});
    }

    public static void j(long j, long j2) {
        gxm.add(new long[]{783, j, j2});
    }

    public static void wh() {
        gxn = System.currentTimeMillis();
    }

    public static void wi() {
        if (fg(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT)) {
            j(1, System.currentTimeMillis() - gxn);
            j(2, 1);
        }
    }

    public static void ed(String str) {
        if (fg(WXMediaMessage.TITLE_LENGTH_LIMIT) && ac.cfq().equals(str)) {
            gxo = true;
            x.i("MicroMsg.BlinkStartup", "report this time");
        }
    }

    public static void wj() {
        fg(WXMediaMessage.TITLE_LENGTH_LIMIT);
    }

    public static void au(long j) {
        if (System.currentTimeMillis() - j > 200) {
            fg(WXMediaMessage.TITLE_LENGTH_LIMIT);
            gxo = false;
        }
    }

    public static void wk() {
        fg(WXMediaMessage.TITLE_LENGTH_LIMIT);
        gxo = false;
    }

    public static void av(long j) {
        gxp = j;
        gxq = j;
    }

    private static void a(int[] iArr, long j) {
        x.i("MicroMsg.BlinkStartup", "%s %s", Integer.valueOf(iArr[0]), Long.valueOf(j));
        i((long) iArr[0], j);
        if (com.tencent.mm.f.a.oG) {
            i((long) iArr[1], j);
        } else {
            i((long) iArr[2], j);
        }
    }

    public static boolean wl() {
        if (gxo) {
            return fg(256);
        }
        return false;
    }

    private static boolean fg(int i) {
        if ((gxr & i) != 0) {
            return false;
        }
        gxr = (byte) (gxr | i);
        x.i("MicroMsg.BlinkStartup", "checkAndMark bit 0x%x", Integer.valueOf(i));
        return true;
    }

    private static void aw(long j) {
        if (j > 10000) {
            wk();
        }
    }

    public static void fh(int i) {
        if (gxq == 0) {
            x.e("MicroMsg.BlinkStartup", "sLastPhaseTimestamp is 0");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - gxq;
        switch (i) {
            case 1:
                if (fg(1)) {
                    a(gxb, currentTimeMillis);
                    gxq = System.currentTimeMillis();
                    return;
                }
                return;
            case 2:
                if (fg(2)) {
                    a(gxc, currentTimeMillis);
                    gxq = System.currentTimeMillis();
                    return;
                }
                return;
            case 3:
                if (fg(4)) {
                    a(gxd, currentTimeMillis);
                    gxq = System.currentTimeMillis();
                    return;
                }
                return;
            case 4:
                if (fg(8)) {
                    a(gxe, currentTimeMillis);
                    gxq = System.currentTimeMillis();
                    return;
                }
                return;
            case 5:
                if (fg(16)) {
                    aw(currentTimeMillis);
                    a(gxf, currentTimeMillis);
                    gxq = System.currentTimeMillis();
                    return;
                }
                return;
            case 6:
                if (fg(32)) {
                    aw(currentTimeMillis);
                    a(gxg, currentTimeMillis);
                    gxq = System.currentTimeMillis();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public static void wm() {
        long currentTimeMillis = System.currentTimeMillis() - gxp;
        a(gxh, currentTimeMillis);
        if (currentTimeMillis <= 3000) {
            a(gxi, 1);
        } else if (currentTimeMillis > 3000 && currentTimeMillis <= 6000) {
            a(gxj, 1);
        } else if (currentTimeMillis <= 6000 || currentTimeMillis > 10000) {
            a(gxl, 1);
        } else {
            a(gxk, 1);
        }
        a(gxa, 1);
    }

    public static ArrayList<long[]> wn() {
        return gxm;
    }
}
