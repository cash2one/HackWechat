package com.tencent.mm.plugin.accountsync.a;

import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.z.ar;

class c$1 implements a {
    c$1() {
    }

    public final boolean uF() {
        c.vC();
        if (c.bl() == 1 || c.bl() == 16 || c.bl() % 96 == 0) {
            ar.getNotification().wZ();
        }
        return true;
    }
}
