package com.tencent.xweb.util;

import com.tencent.xweb.WebView.c;
import com.tencent.xweb.g;
import com.tencent.xweb.q;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import org.xwalk.core.XWalkEnvironment;

public final class e {
    static q ArB = null;
    public static String fqu = "";

    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] ArC = new int[c.values().length];

        static {
            try {
                ArC[c.AqB.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                ArC[c.AqC.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                ArC[c.AqD.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static void b(c cVar) {
        if (ArB != null) {
            String str;
            if ((cVar == c.AqB ? 1 : null) != null) {
                str = "REPORT_APK_VER_TIME";
            } else {
                str = "REPORT_APK_VER_TIME_" + cVar;
            }
            String format = new SimpleDateFormat("yyyyMMdd").format(new Date());
            Object string = XWalkEnvironment.getSharedPreferences().getString(str, "");
            if (string == null) {
                string = "";
            }
            if (!format.equals(string)) {
                int i;
                if (cVar == c.AqB) {
                    int availableVersion = XWalkEnvironment.getAvailableVersion();
                    if (availableVersion > 0) {
                        i = 99;
                        ArB.h((long) ((availableVersion % 50) + 100), 1);
                    } else {
                        return;
                    }
                } else if (cVar == c.AqD) {
                    i = 97;
                } else if (cVar == c.AqC) {
                    i = 98;
                } else {
                    return;
                }
                ArB.h((long) i, 1);
                XWalkEnvironment.getSharedPreferences().edit().putString(str, format).apply();
            }
        }
    }

    public static void a(q qVar) {
        ArB = qVar;
    }

    public static void be(int i, String str) {
        if (ArB != null) {
            ArB.k(i, str);
        }
    }

    public static void gB(long j) {
        if (ArB != null) {
            ArB.h(j, 1);
        }
    }

    public static void cIC() {
        if (ArB != null) {
            ArB.h(0, 1);
        }
    }

    public static void cID() {
        if (ArB != null) {
            ArB.h(1, 1);
        }
    }

    public static void gC(long j) {
        if (ArB != null && j > 0 && j < 300000) {
            ArB.w(2, 3, (int) j);
        }
    }

    public static void cIE() {
        if (ArB != null) {
            ArB.h(46, 1);
        }
    }

    public static void cIF() {
        if (ArB != null) {
            ArB.h(47, 1);
        }
    }

    public static void gD(long j) {
        if (ArB != null && j > 0 && j < 300000) {
            ArB.w(48, 49, (int) j);
        }
    }

    public static void cIG() {
        if (ArB != null) {
            ArB.h(42, 1);
        }
    }

    public static void cIH() {
        if (ArB != null) {
            ArB.h(43, 1);
        }
    }

    public static void gE(long j) {
        if (ArB != null && j > 0 && j < 300000) {
            ArB.w(44, 45, (int) j);
        }
    }

    public static void dM(String str, int i) {
        if (ArB != null) {
            cIC();
            fqu = UUID.randomUUID().toString().replace("-", "");
            ArB.h(4, 1);
            ArB.a(XWalkEnvironment.getAvailableVersion(), acr(str), fqu, g.cIm() == null ? 100 : g.cIm().ordinal(), 0, 0, 0, i);
        }
    }

    public static void c(String str, int i, long j, int i2) {
        if (ArB != null) {
            cID();
            ArB.h(5, 1);
            ArB.k(15003, "");
            ArB.a(XWalkEnvironment.getAvailableVersion(), acr(str), fqu, g.cIm() == null ? 100 : g.cIm().ordinal(), 1, i, (int) j, i2);
        }
    }

    public static void j(String str, long j, int i) {
        gC(j);
        if (ArB != null && j > 0 && j < 300000) {
            ArB.w(6, 7, (int) j);
            ArB.a(XWalkEnvironment.getAvailableVersion(), acr(str), fqu, g.cIm() == null ? 100 : g.cIm().ordinal(), 1, 0, (int) j, i);
        }
    }

    public static int acr(String str) {
        if (str.startsWith("https://servicewechat.com/")) {
            return 0;
        }
        if (str.startsWith("http://mp.weixin.qq.com/") || str.startsWith("https://mp.weixin.qq.com/") || str.startsWith("https://servicewechat.com/preload/") || str.startsWith("http://mp.weixinbridge.com/")) {
            return 1;
        }
        return 2;
    }

    public static void cII() {
        if (ArB != null) {
            ArB.h(9, 1);
        }
    }

    public static void gF(long j) {
        if (ArB != null && ArB != null && j > 0 && j < 600000) {
            ArB.w(11, 12, (int) j);
        }
    }

    public static void cIJ() {
        if (ArB != null) {
            ArB.h(10, 1);
        }
    }

    public static void cIK() {
        if (ArB != null) {
            ArB.h(20, 1);
        }
    }

    public static void gG(long j) {
        if (ArB != null && ArB != null && j > 0 && j < 600000) {
            ArB.w(22, 23, (int) j);
        }
    }

    public static void cIL() {
        if (ArB != null) {
            ArB.h(21, 1);
        }
    }

    public static void cIM() {
        if (ArB != null) {
            ArB.h(25, 1);
        }
    }

    public static void gH(long j) {
        if (ArB != null && ArB != null && j > 0 && j < 600000) {
            ArB.w(27, 28, (int) j);
        }
    }

    public static void cIN() {
        if (ArB != null) {
            ArB.h(26, 1);
        }
    }

    public static void cIO() {
        if (ArB != null) {
            ArB.h(14, 1);
        }
    }

    public static void cIP() {
        if (ArB != null) {
            ArB.h(15, 1);
        }
    }

    public static void gI(long j) {
        if (ArB != null && ArB != null && j > 0 && j < 120000) {
            ArB.w(16, 17, (int) j);
        }
    }

    public static void cIQ() {
        if (ArB != null) {
            ArB.h(83, 1);
        }
    }

    public static void c(c cVar) {
        if (ArB != null) {
            int i;
            switch (AnonymousClass1.ArC[cVar.ordinal()]) {
                case 1:
                    i = 82;
                    break;
                case 2:
                    i = 81;
                    break;
                case 3:
                    i = 80;
                    break;
                default:
                    return;
            }
            ArB.h((long) i, 1);
        }
    }

    public static void cIR() {
        if (ArB != null) {
            ArB.h(87, 1);
        }
    }

    public static void d(c cVar) {
        if (ArB != null) {
            int i;
            switch (AnonymousClass1.ArC[cVar.ordinal()]) {
                case 1:
                    i = 86;
                    break;
                case 2:
                    i = 85;
                    break;
                case 3:
                    i = 84;
                    break;
                default:
                    return;
            }
            ArB.h((long) i, 1);
        }
    }

    public static void cIS() {
        if (ArB != null) {
            ArB.h(88, 1);
        }
    }
}
