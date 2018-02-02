package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.VoiceSearchLayout.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

class p$1 implements a {
    final /* synthetic */ p vyZ;

    p$1(p pVar) {
        this.vyZ = pVar;
    }

    public final void caN() {
        if (!com.tencent.mm.p.a.aW(ac.getContext()) && !com.tencent.mm.p.a.aU(ac.getContext())) {
            x.d("MicroMsg.VoiceSearchViewHelper", "on voice search start");
            g.pQN.h(10453, new Object[]{Integer.valueOf(this.vyZ.vyV), Integer.valueOf(3)});
            if (this.vyZ.vyX != null) {
                this.vyZ.vyX.ass();
            }
        }
    }

    public final void caO() {
        x.d("MicroMsg.VoiceSearchViewHelper", "on voice search cancel");
        g.pQN.h(10453, new Object[]{Integer.valueOf(this.vyZ.vyV), Integer.valueOf(4)});
        if (this.vyZ.zmr != null) {
            this.vyZ.zmr.np(true);
            this.vyZ.zmr.nq(true);
        }
        if (this.vyZ.vyX != null) {
            this.vyZ.vyX.ast();
        }
    }

    public final void a(boolean z, String[] strArr, long j) {
        x.d("MicroMsg.VoiceSearchViewHelper", "on voice search return, success %B, voice id %d", new Object[]{Boolean.valueOf(z), Long.valueOf(j)});
        if (this.vyZ.vyX != null) {
            this.vyZ.vyX.a(z, strArr, j, this.vyZ.vyW);
        }
    }
}
