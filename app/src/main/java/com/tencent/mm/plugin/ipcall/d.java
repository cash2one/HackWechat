package com.tencent.mm.plugin.ipcall;

import com.tencent.mm.k.g;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class d {
    public static boolean aTd() {
        if (!ar.Hj()) {
            return false;
        }
        if (g.zY().getInt("WCOEntranceSwitch", 0) > 0) {
            ar.Hg();
            c.CU().a(a.xpr, Boolean.valueOf(true));
            return true;
        }
        ar.Hg();
        c.CU().a(a.xpr, Boolean.valueOf(false));
        return false;
    }
}
