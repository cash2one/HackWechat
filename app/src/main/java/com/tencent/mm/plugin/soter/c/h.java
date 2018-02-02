package com.tencent.mm.plugin.soter.c;

import com.tencent.mm.compatible.d.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class h {
    private static String TAG = "MicroMsg.SoterUtil";

    public static void bCQ() {
        x.i(TAG, "alvinluo dynamic config support soter: %b", Boolean.valueOf(bh.getInt(((a) g.Df().h(a.class)).zY().getValue("SoterEntry"), 0) == 1));
        if (bh.getInt(((a) g.Df().h(a.class)).zY().getValue("SoterEntry"), 0) == 1) {
            x.d(TAG, "alvinluo set all soter support flag to true");
            q.gGa.fIP = true;
            q.gFY.gGh = 1;
            q.gFY.gGi = 1;
            x.d(TAG, "alvinluo deviceInfo soter support: %b, force status: %d, allow external: %d", Boolean.valueOf(q.gGa.fIP), Integer.valueOf(q.gFY.gGh), Integer.valueOf(q.gFY.gGi));
        }
    }

    public static String bCR() {
        try {
            String s = com.tencent.mm.a.g.s(com.tencent.mm.z.q.FV().getBytes());
            if (s != null) {
                return s.substring(0, 8);
            }
        } catch (Throwable e) {
            x.printErrStackTrace(TAG, e, "alvinluo get md5 exception", new Object[0]);
        }
        return "";
    }

    public static String bCS() {
        return "WechatAuthKeyPay&" + com.tencent.mm.z.q.FV();
    }

    public static boolean bCT() {
        if (q.gGa.fIP) {
            return com.tencent.d.b.a.cFW();
        }
        x.i(TAG, "hy: dynamic config is not support soter");
        return false;
    }
}
