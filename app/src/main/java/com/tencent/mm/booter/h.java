package com.tencent.mm.booter;

import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class h {
    public static boolean wN() {
        try {
            ar.Hg();
            t.d((Long) c.CU().get(66817, null));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.PostTaskMediaNoteStat", e, "", new Object[0]);
        }
        if (t.by(0) * 1000 > 1800000) {
            return true;
        }
        return false;
    }
}
