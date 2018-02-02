package com.tencent.mm.plugin.appbrand.dynamic;

import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.ac;

public final class g {
    private static a iSg = new 1();

    public static void initialize() {
        if (ac.cfw()) {
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.Di().a(iSg);
        }
    }

    public static void release() {
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().b(iSg);
    }
}
