package com.tencent.mm.wallet_core;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;

public final class b {
    private static b zHd;

    public static b cBf() {
        if (zHd == null) {
            zHd = new b();
        }
        return zHd;
    }

    public static boolean cBg() {
        int i;
        c fn = com.tencent.mm.z.c.c.IF().fn("100368");
        if (fn.isValid() && "1".equals(fn.chI().get("open"))) {
            i = 1;
        } else {
            i = 0;
        }
        x.d("MicroMsg.TenPaySdkAbTest", "isPwdOpen2048 %s", new Object[]{Integer.valueOf(i)});
        if (i > 0) {
            return true;
        }
        return false;
    }

    public static boolean cBh() {
        int i;
        c fn = com.tencent.mm.z.c.c.IF().fn("100370");
        if (fn.isValid() && "1".equals(fn.chI().get("open"))) {
            i = 1;
        } else {
            i = 0;
        }
        x.d("MicroMsg.TenPaySdkAbTest", "isOfflineOpen2048 %s", new Object[]{Integer.valueOf(i)});
        if (i > 0) {
            return true;
        }
        return false;
    }
}
