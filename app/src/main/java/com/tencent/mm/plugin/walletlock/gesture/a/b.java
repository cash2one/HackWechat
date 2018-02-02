package com.tencent.mm.plugin.walletlock.gesture.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;

public final class b {
    public static boolean bNN() {
        return ((Boolean) g.Dj().CU().get(a.xwE, Boolean.valueOf(false))).booleanValue();
    }

    public static boolean bNO() {
        g bNP = d.bNP();
        x.v("MicroMsg.GestureUtil", "alvinluo timeInfo: %d, %d", new Object[]{Long.valueOf(bNP.tfU), Long.valueOf(bNP.tfV)});
        if (bNP.tfU != -1) {
            e.a(bNP);
            if (bNP.tfV / 1000 < 600) {
                d.G(bNP.tfU, bNP.tfV);
                return true;
            }
            d.bNQ();
        }
        return false;
    }
}
