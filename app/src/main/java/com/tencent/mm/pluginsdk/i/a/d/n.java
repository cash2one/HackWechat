package com.tencent.mm.pluginsdk.i.a.d;

import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;

final class n {
    public static void bZB() {
        if (g.Dh().Cy()) {
            g.Dh();
            if (!a.Cs() && getNetworkType() != 0) {
                long Wo = bh.Wo();
                if (bh.a((Long) g.Dj().CU().get(w.a.xpU, null), 0) < Wo) {
                    g.Dj().CU().a(w.a.xpU, Long.valueOf(7200 + Wo));
                    x.i("MicroMsg.PostTaskCheckResume", "doCheckResume");
                    o.a.bZC().Dm().F(new 1());
                }
            }
        }
    }

    static int getNetworkType() {
        switch (com.tencent.mm.compatible.d.w.yV()) {
            case 0:
                return 0;
            case 1:
                return 1;
            default:
                return 2;
        }
    }
}
