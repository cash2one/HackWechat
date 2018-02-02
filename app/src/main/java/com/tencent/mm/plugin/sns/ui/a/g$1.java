package com.tencent.mm.plugin.sns.ui.a;

import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sns.ui.av;

class g$1 implements e {
    final /* synthetic */ boolean qPf;
    final /* synthetic */ long rAC;
    final /* synthetic */ av rPd;
    final /* synthetic */ g rPe;

    g$1(g gVar, av avVar, long j, boolean z) {
        this.rPe = gVar;
        this.rPd = avVar;
        this.rAC = j;
        this.qPf = z;
    }

    public final void d(b bVar, int i) {
        if (i != -1 && this.rPd != null && this.rPd.rHp != null && this.rPd.rHp.rrs != null) {
            this.rPd.rHp.rrs.m(this.rAC, this.qPf);
        }
    }
}
