package com.tencent.mm.plugin.hp.b;

import com.tencent.mm.g.a.e;
import com.tencent.mm.plugin.hp.tinker.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tinkerboots.sdk.a;

public final class f extends c<e> {
    private static long bpv = 0;

    public f() {
        this.xen = e.class.getName().hashCode();
    }

    private boolean a(e eVar) {
        if (!(eVar.fmQ.fmR || ar.GZ())) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - bpv < 21600000) {
                currentTimeMillis = ac.getContext().getSharedPreferences("tinker_patch_share_config", 4).getLong("tinker_delay_download", 0);
                x.d("MicroMsg.Tinker.TinkerBootsActivateListener", "wait for next time. will check after %d second deployTime:%s", Long.valueOf((21600000 - r2) / 1000), Long.valueOf(currentTimeMillis));
                if (currentTimeMillis > 0 && System.currentTimeMillis() >= currentTimeMillis) {
                    com.tencent.mm.plugin.hp.d.c.a(new 1(this));
                    g.g(ac.getContext(), 0);
                }
            } else if (a.cJn() != null) {
                a.cJn().oe(false);
                x.i("MicroMsg.Tinker.TinkerBootsActivateListener", "callback post task and fetchPatchUpdate false");
                bpv = currentTimeMillis;
            }
        }
        return false;
    }

    public static void dw(long j) {
        bpv = j;
    }
}
