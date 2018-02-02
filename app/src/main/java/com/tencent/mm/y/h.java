package com.tencent.mm.y;

import com.tencent.mm.storage.au;

public final class h {
    public static int g(au auVar) {
        if (!auVar.aNc()) {
            return 0;
        }
        g$a I = g$a.I(auVar.field_content, auVar.field_reserved);
        if (I == null) {
            return 0;
        }
        return I.type;
    }
}
