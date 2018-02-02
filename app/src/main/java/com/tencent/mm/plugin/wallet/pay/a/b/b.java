package com.tencent.mm.plugin.wallet.pay.a.b;

import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    private static long sED = 0;

    public static void S(String str, int i, int i2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - sED > 1000) {
            k cVar;
            sED = currentTimeMillis;
            if (!bh.ov(str)) {
                if (str.startsWith("sns_aa_")) {
                    cVar = new c(str, i, i2);
                } else if (str.startsWith("sns_tf_")) {
                    cVar = new f(str, i, i2);
                } else if (str.startsWith("sns_ff_")) {
                    cVar = new e(str, i, i2);
                } else if (str.startsWith("sns_")) {
                    cVar = new d(str, i, i2);
                } else if (str.startsWith("ts_")) {
                    cVar = new g(str, i, i2);
                }
                if (cVar != null) {
                    x.v("NetSceneCancelPayHelper", "start cancelPay request");
                    g.Dk();
                    g.Di().gPJ.a(cVar, 0);
                }
            }
            cVar = null;
            if (cVar != null) {
                x.v("NetSceneCancelPayHelper", "start cancelPay request");
                g.Dk();
                g.Di().gPJ.a(cVar, 0);
            }
        }
    }
}
