package com.tencent.mm.app.plugin;

import com.tencent.mm.bm.d;
import com.tencent.mm.k.g;
import com.tencent.mm.sdk.platformtools.bh;

public final class b {
    public static boolean uA() {
        if (!d.OQ("translate")) {
            return false;
        }
        String value = g.zY().getValue("TranslateMsgOff");
        if (bh.ov(value)) {
            return true;
        }
        if (bh.VI(value) == 0) {
            return true;
        }
        return false;
    }
}
