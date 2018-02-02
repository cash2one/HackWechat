package com.tencent.mm.plugin.nearby.a;

import com.tencent.mm.g.b.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;

public final class b {
    public static final int oNW = 1;
    private static final /* synthetic */ int[] oNX = new int[]{oNW};

    public static boolean dz(String str, String str2) {
        af xVar = new x();
        xVar.dc(str2);
        xVar.setUsername(str);
        ar.Hg();
        com.tencent.mm.storage.ar EY = c.EY();
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.LbsroomLogic", "Save lbsroom contact name:" + xVar.field_username);
        if (!EY.WQ(xVar.field_username)) {
            EY.R(xVar);
        }
        ar.Hg();
        c.CU().set(143873, str);
        ar.Hg();
        c.CU().set(143874, Long.valueOf(bh.Wo()));
        return true;
    }

    public static void bN(String str, int i) {
        ar.Hg();
        ar.CG().a(new d(str, (int) bh.by(bh.c((Long) c.CU().get(143874, Long.valueOf(0)))), i), 0);
    }

    public static void tN(int i) {
        ar.Hg();
        String ou = bh.ou((String) c.CU().get(143873, ""));
        if (!ou.equals("")) {
            ar.Hg();
            if (bh.by(bh.c((Long) c.CU().get(143874, Long.valueOf(0)))) < 7200) {
                bN(ou, i);
            } else {
                Gz(ou);
            }
        }
    }

    public static boolean beQ() {
        ar.Hg();
        return bh.e((Integer) c.CU().get(143875, Integer.valueOf(0))) == 1;
    }

    public static void beR() {
        ar.Hg();
        c.CU().set(143875, Integer.valueOf(1));
    }

    public static void beS() {
        ar.Hg();
        c.CU().set(143875, Integer.valueOf(0));
    }

    public static void Gz(String str) {
        ar.Hg();
        com.tencent.mm.storage.ar EY = c.EY();
        if (EY.WQ(str)) {
            EY.WU(str);
        }
        ba.a(str, new 1());
        ar.Hg();
        c.CU().set(143873, "");
        ar.Hg();
        c.CU().set(143874, Long.valueOf(0));
        beS();
    }
}
