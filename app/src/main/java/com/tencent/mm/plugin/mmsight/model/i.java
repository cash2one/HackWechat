package com.tencent.mm.plugin.mmsight.model;

import com.tencent.mm.sdk.platformtools.ag;

public final class i {
    private static ag osT = new ag("MMSightHandler");

    public static void A(Runnable runnable) {
        osT.F(runnable);
    }

    public static void B(Runnable runnable) {
        osT.g(runnable, 2000);
    }
}
