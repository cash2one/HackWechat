package com.tencent.mm.plugin.sns.ui.a;

import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sns.ui.av;

class h$2 implements e {
    final /* synthetic */ long rAC;
    final /* synthetic */ av rPd;
    final /* synthetic */ h rPk;

    h$2(h hVar, av avVar, long j) {
        this.rPk = hVar;
        this.rPd = avVar;
        this.rAC = j;
    }

    public final void d(b bVar, int i) {
        if (i != -1 && this.rPd != null && this.rPd.rHp != null && this.rPd.rHp.rrs != null) {
            this.rPd.rHp.rrs.m(this.rAC, false);
        }
    }
}
