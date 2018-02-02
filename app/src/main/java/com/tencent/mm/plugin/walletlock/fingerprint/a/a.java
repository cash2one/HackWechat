package com.tencent.mm.plugin.walletlock.fingerprint.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.walletlock.gesture.a.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.t;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a {
    private static long tfu = -1;

    private static JSONArray NC(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new JSONArray(str);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FingerprintInfoStorage", e, "", new Object[0]);
            return null;
        }
    }

    private static HashSet<String> z(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        try {
            HashSet<String> hashSet = new HashSet();
            for (int i = 0; i < jSONArray.length(); i++) {
                hashSet.add(jSONArray.getJSONObject(i).getString("fid"));
            }
            return hashSet;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FingerprintInfoStorage", e, "", new Object[0]);
            return null;
        }
    }

    private static String bNA() {
        return (String) g.Dj().CU().get(com.tencent.mm.storage.w.a.xwD, null);
    }

    public static boolean ND(String str) {
        x.i("MicroMsg.FingerprintInfoStorage", "alvinluo add fid to local: %s", new Object[]{str});
        try {
            JSONArray NC = NC(bNA());
            HashSet z = z(NC);
            if (NC == null) {
                x.w("MicroMsg.FingerprintInfoStorage", "alvinluo list is null");
                NC = new JSONArray();
            }
            if (z == null) {
                x.w("MicroMsg.FingerprintInfoStorage", "alvinluo fidSet is null");
                z = new HashSet();
            }
            x.i("MicroMsg.FingerprintInfoStorage", "alvinluo fidList: %s before add fid", new Object[]{NC.toString()});
            if (!z.contains(str)) {
                x.w("MicroMsg.FingerprintInfoStorage", "alvinluo fidSet contains fid %s: %b", new Object[]{str, Boolean.valueOf(false)});
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("fid", str);
                NC.put(jSONObject);
                x.i("MicroMsg.FingerprintInfoStorage", "alvinluo list: %s", new Object[]{NC.toString()});
                g.Dj().CU().a(com.tencent.mm.storage.w.a.xwD, NC.toString());
                g.Dj().CU().lH(true);
                return true;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FingerprintInfoStorage", e, "", new Object[0]);
        }
        return false;
    }

    public static boolean NE(String str) {
        x.i("MicroMsg.FingerprintInfoStorage", "alvinluo fid: %s, fidInfoList: %s", new Object[]{str, bNA()});
        HashSet z = z(NC(r2));
        if (z == null || !z.contains(str)) {
            return false;
        }
        return true;
    }

    public static void bNB() {
        x.i("MicroMsg.FingerprintInfoStorage", "alvinluo clear local fids, stack: %s", new Object[]{bh.cgy()});
        g.Dj().CU().a(com.tencent.mm.storage.w.a.xwD, null);
        g.Dj().CU().lH(true);
    }

    public static boolean bNC() {
        return ((Boolean) g.Dj().CU().get(com.tencent.mm.storage.w.a.xwC, Boolean.valueOf(false))).booleanValue();
    }

    public static void jU(boolean z) {
        x.i("MicroMsg.FingerprintInfoStorage", "alvinluo set fingerprint lock status isOpened: %b", new Object[]{Boolean.valueOf(z)});
        g.Dj().CU().a(com.tencent.mm.storage.w.a.xwC, Boolean.valueOf(z));
        g.Dj().CU().lH(true);
    }

    public static boolean bND() {
        com.tencent.mm.plugin.walletlock.gesture.a.g gVar;
        t CU = g.Dj().CU();
        if (CU == null) {
            gVar = new com.tencent.mm.plugin.walletlock.gesture.a.g();
        } else {
            String str = (String) CU.get(com.tencent.mm.storage.w.a.xwG, null);
            gVar = str == null ? new com.tencent.mm.plugin.walletlock.gesture.a.g() : new com.tencent.mm.plugin.walletlock.gesture.a.g().aU(e.NF(str));
        }
        if (gVar.tfU == -1) {
            return false;
        }
        e.a(gVar);
        if (gVar.tfV / 1000 < 30) {
            G(gVar.tfU, gVar.tfV);
            return true;
        }
        CU = g.Dj().CU();
        if (CU != null) {
            CU.a(com.tencent.mm.storage.w.a.xwG, null);
            CU.lH(true);
        }
        return false;
    }

    public static void G(long j, long j2) {
        t CU = g.Dj().CU();
        if (CU != null) {
            com.tencent.mm.plugin.walletlock.gesture.a.g gVar = new com.tencent.mm.plugin.walletlock.gesture.a.g();
            gVar.tfU = j;
            gVar.tfV = j2;
            CU.a(com.tencent.mm.storage.w.a.xwG, e.aT(gVar.toByteArray()));
            CU.lH(true);
        }
    }

    public static void bNE() {
        tfu = -1;
    }

    public static long bNF() {
        return tfu;
    }

    public static void fh(long j) {
        tfu = j;
    }
}
