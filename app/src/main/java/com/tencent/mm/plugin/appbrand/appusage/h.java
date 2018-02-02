package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w.a;

public final class h {
    public static final c iJw = new c();

    public static final class c {
    }

    private static void a(boolean z, long j) {
        if (z) {
            long j2;
            if (j == 0) {
                j2 = Long.MAX_VALUE;
            } else {
                j2 = bh.Wo() + Math.max(0, j);
            }
            g.Dj().CU().a(a.xrP, Long.valueOf(j2));
            g.Dj().CU().a(a.xsb, Boolean.valueOf(true));
            g.Dj().CU().a(a.xrV, Boolean.valueOf(false));
            e eVar = e.iJI;
            e.a((String) g.Dj().CU().get(a.xrQ, ""), ((Long) g.Dj().CU().get(a.xrR, Long.valueOf(0))).longValue(), 1, e.aba());
            return;
        }
        g.Dj().CU().a(a.xrP, Long.valueOf(0));
    }

    private static void a(boolean z, long j, long j2) {
        long j3 = 0;
        t CU = g.Dj().CU();
        a aVar = a.xrY;
        if (z) {
            j3 = Math.max(0, j) + bh.Wo();
        }
        CU.a(aVar, Long.valueOf(j3));
        t CU2 = g.Dj().CU();
        a aVar2 = a.xsa;
        if (!z) {
            j2 = Long.MAX_VALUE;
        }
        CU2.a(aVar2, Long.valueOf(j2));
    }

    public static boolean aaU() {
        g.aaL();
        if (g.Dh().Cy()) {
            return ((Boolean) g.Dj().CU().get(a.xsb, Boolean.valueOf(false))).booleanValue();
        }
        return false;
    }

    static a aaV() {
        int i = 0;
        if (!aaW()) {
            return a.iJx;
        }
        int intValue = ((Integer) g.Dj().CU().get(a.xrS, Integer.valueOf(0))).intValue();
        a[] values = a.values();
        int length = values.length;
        while (i < length) {
            a aVar = values[i];
            if (aVar.value == intValue) {
                return aVar;
            }
            i++;
        }
        return a.iJx;
    }

    public static boolean aaW() {
        if (!g.Dh().Cy()) {
            return false;
        }
        long longValue = ((Long) g.Dj().CU().get(a.xrP, Long.valueOf(0))).longValue();
        boolean z = longValue > bh.Wo();
        if (!z && longValue > 0) {
            g.Dj().CU().a(a.xrP, Long.valueOf(0));
            e eVar = e.iJI;
            e.a((String) g.Dj().CU().get(a.xrQ, ""), ((Long) g.Dj().CU().get(a.xrR, Long.valueOf(0))).longValue(), 3, e.aba());
        }
        return z;
    }

    static void aaX() {
        g.aaL();
        if (g.Dh().Cy()) {
            e eVar = e.iJI;
            if (!((Boolean) g.Dj().CU().get(a.xrV, Boolean.valueOf(false))).booleanValue()) {
                e.a((String) g.Dj().CU().get(a.xrQ, ""), ((Long) g.Dj().CU().get(a.xrR, Long.valueOf(0))).longValue(), 0, e.aba());
                g.Dj().CU().a(a.xrV, Boolean.valueOf(true));
            }
        }
    }

    public static void aaY() {
        if (g.Dh().Cy() && aaW()) {
            a(false, 0);
            a(false, 0, 0);
            e eVar = e.iJI;
            e.a((String) g.Dj().CU().get(a.xrQ, ""), ((Long) g.Dj().CU().get(a.xrR, Long.valueOf(0))).longValue(), 2, e.aba());
        }
    }
}
