package com.tencent.mm.plugin.appbrand.l;

import com.tencent.mm.storage.c;

public final class a {
    public static boolean ake() {
        boolean z;
        c fn = com.tencent.mm.z.c.c.IF().fn("100159");
        if (fn.isValid() && "1".equals(fn.chI().get("isCloseWeappSearch"))) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return false;
        }
        return true;
    }
}
