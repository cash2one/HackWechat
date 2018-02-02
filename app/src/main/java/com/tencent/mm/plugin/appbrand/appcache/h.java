package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.c;

public final class h {
    public static boolean ZG() {
        if (!g.Dh().Cy()) {
            return false;
        }
        c fn = com.tencent.mm.z.c.c.IF().fn("100310");
        return fn.isValid() && bh.getInt((String) fn.chI().get("shouldUsePatch"), 0) == 1;
    }

    public static boolean ZH() {
        if (!g.Dh().Cy()) {
            return false;
        }
        c fn = com.tencent.mm.z.c.c.IF().fn("100342");
        return fn.isValid() && bh.getInt((String) fn.chI().get("shouldUsePatch"), 0) == 1;
    }

    public static boolean ZI() {
        if (!g.Dh().Cy()) {
            return false;
        }
        c fn = com.tencent.mm.z.c.c.IF().fn("100320");
        return fn.isValid() && bh.getInt((String) fn.chI().get("isOpenModule"), 0) > 0;
    }
}
