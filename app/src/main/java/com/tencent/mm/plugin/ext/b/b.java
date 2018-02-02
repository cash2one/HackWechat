package com.tencent.mm.plugin.ext.b;

import com.tencent.mm.storage.au;

public final class b {
    public static int M(au auVar) {
        if (auVar.getType() == 34) {
            return 2;
        }
        if (auVar.getType() != 1) {
            return 3;
        }
        return 1;
    }
}
