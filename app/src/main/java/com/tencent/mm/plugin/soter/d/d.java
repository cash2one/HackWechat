package com.tencent.mm.plugin.soter.d;

import android.content.SharedPreferences;
import com.tencent.d.a.c.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;

public final class d implements a<Boolean, Boolean> {
    private b igh = null;

    public final /* synthetic */ Object call(Object obj) {
        Boolean bool = (Boolean) obj;
        this.igh = g.czQ();
        x.v("MicroMsg.SoterSaveDeviceInfoFunc", "alvinluo isNeedSaveDeviceInfo: %b", new Object[]{bool});
        if (!com.tencent.d.b.a.cFW()) {
            x.w("MicroMsg.SoterSaveDeviceInfoFunc", "alvinluo not support soter");
            this.igh.cl(g.u(Integer.valueOf(2), "not support soter"));
        } else if (bool.booleanValue()) {
            SharedPreferences cft = ac.cft();
            if (cft != null) {
                x.i("MicroMsg.SoterSaveDeviceInfoFunc", "alvinluo old cpuId: %s, old uid: %s", new Object[]{cft.getString("cpu_id", null), cft.getString("uid", null)});
                if (bh.ov(cft.getString("cpu_id", null)) || bh.ov(r0)) {
                    h cFN = com.tencent.d.a.a.cFN();
                    if (cFN != null) {
                        String str = cFN.rSm;
                        String valueOf = String.valueOf(cFN.uid);
                        if (!(bh.ov(str) || bh.ov(valueOf))) {
                            com.tencent.mm.plugin.soter.c.b.eq(str, valueOf);
                        }
                    }
                }
            }
        }
        return Boolean.valueOf(true);
    }
}
