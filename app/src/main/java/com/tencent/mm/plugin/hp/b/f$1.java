package com.tencent.mm.plugin.hp.b;

import com.tencent.mm.plugin.hp.d.b;
import com.tencent.mm.plugin.hp.d.c.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class f$1 implements a {
    final /* synthetic */ f nAP;

    f$1(f fVar) {
        this.nAP = fVar;
    }

    public final void a(boolean z, b bVar) {
        if (z && bVar != null) {
            new e(bVar).fN(true);
            g.pQN.a(614, 75, 1, false);
            x.i("MicroMsg.Tinker.TinkerBootsActivateListener", "process tinker node on activate. It is use bsdiff download.");
        }
    }
}
