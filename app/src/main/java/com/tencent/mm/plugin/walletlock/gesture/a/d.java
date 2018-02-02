package com.tencent.mm.plugin.walletlock.gesture.a;

import android.util.Base64;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.avk;
import com.tencent.mm.protocal.c.avl;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.t;

public final class d {
    private static long tfu = -1;

    public static g bNP() {
        t CU = g.Dj().CU();
        if (CU == null) {
            return new g();
        }
        Object obj = CU.get(339969, null);
        if (obj == null) {
            return new g();
        }
        return new g().aU(e.NF((String) obj));
    }

    public static void G(long j, long j2) {
        t CU = g.Dj().CU();
        if (CU != null) {
            g gVar = new g();
            gVar.tfU = j;
            gVar.tfV = j2;
            CU.set(339969, e.aT(gVar.toByteArray()));
            CU.lH(true);
        }
    }

    public static void bNQ() {
        t CU = g.Dj().CU();
        if (CU != null) {
            CU.set(339969, null);
            CU.lH(true);
        }
    }

    public static long bNF() {
        return tfu;
    }

    public static void fh(long j) {
        tfu = j;
    }

    public static void bNE() {
        tfu = -1;
    }

    public static g bNR() {
        t CU = g.Dj().CU();
        if (CU == null) {
            return new g();
        }
        Object obj = CU.get(339971, null);
        if (obj == null) {
            return new g();
        }
        return new g().aU(e.NF((String) obj));
    }

    public static void H(long j, long j2) {
        t CU = g.Dj().CU();
        if (CU != null) {
            g gVar = new g();
            gVar.tfU = j;
            gVar.tfV = j2;
            CU.set(339971, e.aT(gVar.toByteArray()));
            CU.lH(true);
        }
    }

    public static void bNS() {
        t CU = g.Dj().CU();
        if (CU != null) {
            CU.set(339971, null);
            CU.lH(true);
        }
    }

    public static avk bNT() {
        t CU = g.Dj().CU();
        if (CU == null) {
            return null;
        }
        String str = (String) CU.get(339989, null);
        if (bh.ov(str)) {
            return null;
        }
        try {
            return (avk) new avk().aF(Base64.decode(str, 2));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.GestureGuardInfoManager", e, "", new Object[0]);
            return null;
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.GestureGuardInfoManager", e2, "", new Object[0]);
            return null;
        }
    }

    public static void a(avk com_tencent_mm_protocal_c_avk) {
        t CU = g.Dj().CU();
        if (CU != null) {
            try {
                CU.set(339989, Base64.encodeToString(com_tencent_mm_protocal_c_avk.toByteArray(), 2));
                CU.lH(true);
                x.v("MicroMsg.GestureGuardInfoManager", "alvinluo savePatternBuffer isUserSetGesturePwd: %b", new Object[]{Boolean.valueOf(e.bNN())});
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.GestureGuardInfoManager", e, "", new Object[0]);
            }
        }
    }

    public static avl bNU() {
        t CU = g.Dj().CU();
        if (CU == null) {
            x.e("MicroMsg.GestureGuardInfoManager", "alvinluo configstg is null");
            return null;
        }
        String str = (String) CU.get(339990, null);
        if (bh.ov(str)) {
            return null;
        }
        try {
            return (avl) new avl().aF(Base64.decode(str, 2));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.GestureGuardInfoManager", e, "", new Object[0]);
            return null;
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.GestureGuardInfoManager", e2, "", new Object[0]);
            return null;
        }
    }

    public static void a(avl com_tencent_mm_protocal_c_avl) {
        if (com_tencent_mm_protocal_c_avl != null) {
            x.i("MicroMsg.GestureGuardInfoManager", "alvinluo saveSyncedPatternInfo version: %d, status: %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_avl.wDd), Integer.valueOf(com_tencent_mm_protocal_c_avl.wDf)});
        }
        t CU = g.Dj().CU();
        if (CU != null) {
            try {
                CU.set(339990, Base64.encodeToString(com_tencent_mm_protocal_c_avl.toByteArray(), 2));
                CU.lH(true);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.GestureGuardInfoManager", e, "", new Object[0]);
            }
        }
    }

    public static int bNV() {
        t CU = g.Dj().CU();
        if (CU == null) {
            return -1;
        }
        Object obj = CU.get(339972, null);
        if (obj == null) {
            return -1;
        }
        return ((Integer) obj).intValue();
    }

    public static void zw(int i) {
        t CU = g.Dj().CU();
        if (CU != null) {
            CU.set(339972, Integer.valueOf(i));
            CU.lH(true);
        }
    }

    public static void bNW() {
        t CU = g.Dj().CU();
        if (CU != null) {
            CU.set(339972, null);
            CU.lH(true);
        }
    }
}
