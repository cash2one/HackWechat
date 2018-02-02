package com.tencent.mm.bc;

import android.net.Uri;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class g {
    private static a hKR = new a();

    public static void t(int i, String str) {
        com.tencent.mm.plugin.report.service.g.pQN.k(i, str);
    }

    public static void a(int i, String str, boolean z, boolean z2, int i2) {
        int i3;
        if (z) {
            i3 = 3;
        } else if (z2) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        com.tencent.mm.plugin.report.service.g.pQN.h(12042, new Object[]{Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(i3), Integer.valueOf(i2), bh.az(str, "").replace(",", " ")});
    }

    public static void io(int i) {
        hKR.scene = i;
        hKR.hKS = 1;
        hKR.hKT = System.currentTimeMillis();
        hKR.hKU = 0;
        hKR.hKV = System.currentTimeMillis();
        hKR.hET = 0;
        hKR.hKW = false;
        x.v("MicroMsg.FTS.FTSWebReportLogic", "initReport %d %d", new Object[]{Integer.valueOf(i), Integer.valueOf(1)});
    }

    public static void QY() {
        hKR.hKT = System.currentTimeMillis();
        x.v("MicroMsg.FTS.FTSWebReportLogic", "startH5Report %s", new Object[]{Long.valueOf(hKR.hKT)});
    }

    public static void QZ() {
        a aVar = hKR;
        aVar.hKU += System.currentTimeMillis() - hKR.hKT;
        x.v("MicroMsg.FTS.FTSWebReportLogic", "stopH5Report %s", new Object[]{Long.valueOf(hKR.hKU)});
    }

    public static void Ra() {
        a aVar = hKR;
        aVar.hET += System.currentTimeMillis() - hKR.hKV;
        x.v("MicroMsg.FTS.FTSWebReportLogic", "stopTotalReport %s", new Object[]{Long.valueOf(hKR.hET)});
    }

    public static void Rb() {
        a aVar = hKR;
        if (!aVar.hKW) {
            com.tencent.mm.plugin.report.service.g.pQN.h(12044, new Object[]{Integer.valueOf(aVar.scene), Integer.valueOf(aVar.hKS), Long.valueOf(aVar.hKU / 1000), Long.valueOf(aVar.hET / 1000)});
            aVar.hKW = true;
        }
        x.v("MicroMsg.FTS.FTSWebReportLogic", "reportTime");
    }

    public static void ip(int i) {
        x.v("MicroMsg.FTS.FTSWebReportLogic", "kvReportWebSearchVisit %d", new Object[]{Integer.valueOf(i)});
        com.tencent.mm.plugin.report.service.g.pQN.h(12041, new Object[]{Integer.valueOf(i), Integer.valueOf(com.tencent.mm.plugin.aj.a.g.zN(0))});
    }

    public static void a(int i, int i2, String str, int i3, int i4, String str2, int i5) {
        x.v("MicroMsg.FTS.FTSWebReportLogic", "kvReportWebSearchGuideDisplay %d %d %s %d %d %s %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4), str2, Integer.valueOf(i5)});
        com.tencent.mm.plugin.report.service.g.pQN.h(12098, new Object[]{Integer.valueOf(i), Integer.valueOf(com.tencent.mm.plugin.aj.a.g.zN(0)), Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4), str2, Integer.valueOf(i5)});
    }

    public static void d(String str, int i, int i2, int i3) {
        com.tencent.mm.plugin.report.service.g.pQN.h(12639, new Object[]{bh.az(str, "").replace(",", " "), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(i3)});
    }

    public static void b(int i, int i2, String str) {
        a(i, i2, str, false);
    }

    public static void a(int i, int i2, String str, boolean z) {
        int i3 = 1;
        com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pQN;
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(0);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = str;
        if (!z) {
            i3 = 0;
        }
        objArr[4] = Integer.valueOf(i3);
        gVar.h(12845, objArr);
    }

    public static void u(int i, String str) {
        com.tencent.mm.plugin.report.service.g.pQN.h(12070, new Object[]{Integer.valueOf(i), Integer.valueOf(com.tencent.mm.plugin.aj.a.g.zN(0)), str, Integer.valueOf(4), Integer.valueOf(0), "", Integer.valueOf(1), Integer.valueOf(0)});
    }

    public static void g(int i, String str, String str2) {
        com.tencent.mm.plugin.report.service.g.pQN.h(13809, new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(0)});
    }

    public static void b(String str, String str2, int i, String str3) {
        x.v("MicroMsg.FTS.FTSWebReportLogic", "kvReportWebSearchLocalPageClick %s %s %d %s", new Object[]{str, str2, Integer.valueOf(i), str3});
        com.tencent.mm.plugin.report.service.g.pQN.h(14657, new Object[]{Uri.encode(str), str2, Integer.valueOf(i), str3});
    }

    public static void a(String str, String str2, long j, String str3) {
        x.v("MicroMsg.FTS.FTSWebReportLogic", "kvReportWebSearchLocalPageExposure:");
        com.tencent.mm.plugin.report.service.g.pQN.h(14663, new Object[]{Uri.encode(str), str2, Long.valueOf(j), str3});
    }

    public static void a(int i, String str, String str2, int i2, int i3) {
        com.tencent.mm.plugin.report.service.g.pQN.h(13810, new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(0)});
    }

    public static final void lU(String str) {
        x.v("MicroMsg.FTS.FTSWebReportLogic", "reportWebSuggestClick %s", new Object[]{str});
        com.tencent.mm.plugin.report.service.g.pQN.k(12721, str);
    }

    public static final void iq(int i) {
        com.tencent.mm.plugin.report.service.g.pQN.a(649, (long) i, 1, true);
    }

    public static final void bk(int i, int i2) {
        if (i == 21) {
            com.tencent.mm.plugin.report.service.g.pQN.a(649, (long) i2, 1, true);
        }
    }

    public static void bl(int i, int i2) {
        c(i, i2, "");
    }

    public static void c(int i, int i2, String str) {
        a(i, i2, 0, 0, str);
    }

    public static void z(int i, int i2, int i3) {
        a(i, 3, i2, i3, "");
    }

    public static void a(int i, int i2, int i3, int i4, String str) {
        int zN;
        if (i == 21) {
            zN = com.tencent.mm.plugin.aj.a.g.zN(1);
        } else {
            zN = com.tencent.mm.plugin.aj.a.g.zN(0);
        }
        com.tencent.mm.plugin.report.service.g.pQN.h(14457, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(zN), Integer.valueOf(i3), Integer.valueOf(i4), str});
    }

    public static void n(String str, String str2, String str3) {
        com.tencent.mm.plugin.report.service.g.pQN.h(14752, new Object[]{Integer.valueOf(1), str, str2, str3});
    }
}
