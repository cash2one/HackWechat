package com.tencent.mm.plugin.soter.c;

import com.tencent.mm.g.a.ck;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends c<ck> {
    private static String TAG = "MicroMsg.SoterDynamicConfigUpdatedEventListener";

    public d() {
        this.xen = ck.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        x.i(TAG, "alvinluo dynamic config updated.");
        h.bCQ();
        return true;
    }
}
