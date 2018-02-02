package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Looper;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.c.aip;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.w;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public enum g {
    ;
    
    private static volatile long iJj;
    private static volatile aip iJk;
    private static final Set<b> iJl = null;

    public interface b {
        void aaT();
    }

    static {
        iJl = Collections.newSetFromMap(new ConcurrentHashMap());
    }

    public static void a(b bVar) {
        if (bVar != null) {
            iJl.add(bVar);
        }
    }

    public static void b(b bVar) {
        if (bVar != null) {
            iJl.remove(bVar);
        }
    }

    public static boolean aaL() {
        return true;
    }

    public static boolean aaM() {
        switch (3.iJr[aaN().ordinal()]) {
            case 2:
                return true;
            case 3:
                if (aaO()) {
                    return true;
                }
                return iJk != null && iJk.kkv >= iJk.wpU;
            default:
                return false;
        }
    }

    public static boolean refresh() {
        iJk = null;
        iJj = 0;
        if (a.iJs == aaN()) {
            return false;
        }
        PBool pBool = new PBool();
        PBool pBool2 = new PBool();
        pBool.value = false;
        pBool2.value = false;
        ak akVar = new ak(Looper.getMainLooper(), new 1(pBool2, pBool), false);
        long toMillis = TimeUnit.SECONDS.toMillis(20);
        akVar.J(toMillis, toMillis);
        c.OP().b((a) com.tencent.mm.plugin.appbrand.q.c.bj(new 2(pBool, pBool2)), false);
        return true;
    }

    static a aaN() {
        int i = 0;
        if (!com.tencent.mm.kernel.g.Dh().Cy()) {
            return a.iJs;
        }
        com.tencent.mm.storage.c fn = com.tencent.mm.z.c.c.IF().fn("100215");
        if (fn.isValid()) {
            int i2 = bh.getInt((String) fn.chI().get("isOpenNewNearEntry"), 0);
            a[] values = a.values();
            int length = values.length;
            while (i < length) {
                a aVar = values[i];
                if (aVar.value == i2) {
                    return aVar;
                }
                i++;
            }
        }
        return a.iJs;
    }

    static boolean aaO() {
        return com.tencent.mm.kernel.g.Dj().CU().getBoolean(w.a.xsc, false);
    }

    static void aaP() {
        com.tencent.mm.kernel.g.Dj().CU().a(w.a.xsc, Boolean.valueOf(true));
    }

    public static aip aaQ() {
        return iJk;
    }

    public static boolean aaR() {
        long Wo = bh.Wo();
        long j = (!com.tencent.mm.kernel.g.Dh().Cy() || iJk == null) ? 0 : iJj;
        return Wo >= j;
    }

    public static void aaS() {
        iJk = null;
    }
}
