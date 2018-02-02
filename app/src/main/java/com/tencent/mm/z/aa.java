package com.tencent.mm.z;

import com.tencent.mm.g.b.af;
import com.tencent.mm.l.a;
import com.tencent.mm.storage.x;

public final class aa {
    public static void GN() {
        for (x xVar : s.GH()) {
            if (!(xVar == null || ((int) xVar.gJd) == 0 || xVar.field_showHead != 32)) {
                xVar.ex(xVar.Ad());
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.HardCodeUpdateTask", "contact to updatefavour " + xVar.field_username);
                ar.Hg();
                c.EY().a(xVar.field_username, xVar);
            }
        }
        for (String str : s.hfr) {
            af WO = c.EY().WO(str);
            if (WO != null && (((int) WO.gJd) != 0 || a.fZ(WO.field_type))) {
                WO.Ap();
                c.EY().a(str, WO);
            }
        }
    }
}
