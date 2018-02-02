package com.tencent.mm.plugin.nfc;

import com.tencent.mm.by.h.d;
import com.tencent.mm.z.ap;
import java.util.HashMap;

public final class a implements ap {
    private static com.tencent.mm.plugin.hce.a.a oRH = new com.tencent.mm.plugin.hce.a.a();

    public final HashMap<Integer, d> Bn() {
        return null;
    }

    public final void gd(int i) {
    }

    public final void br(boolean z) {
    }

    public final void bq(boolean z) {
        if (!com.tencent.mm.sdk.b.a.xef.d(oRH)) {
            com.tencent.mm.sdk.b.a.xef.a(oRH);
        }
    }

    public final void onAccountRelease() {
        if (com.tencent.mm.sdk.b.a.xef.d(oRH)) {
            com.tencent.mm.sdk.b.a.xef.c(oRH);
        }
    }
}
