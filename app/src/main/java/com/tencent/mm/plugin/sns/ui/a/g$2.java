package com.tencent.mm.plugin.sns.ui.a;

import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sns.ui.ak;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.sdk.platformtools.bh;

class g$2 implements f {
    final /* synthetic */ int hHw;
    final /* synthetic */ boolean qPf;
    final /* synthetic */ ak rAA;
    final /* synthetic */ long rAC;
    final /* synthetic */ av rPd;
    final /* synthetic */ g rPe;

    g$2(g gVar, av avVar, long j, boolean z, int i, ak akVar) {
        this.rPe = gVar;
        this.rPd = avVar;
        this.rAC = j;
        this.qPf = z;
        this.hHw = i;
        this.rAA = akVar;
    }

    public final void b(b bVar, long j) {
        if (this.rPd != null && this.rPd.rHp != null && this.rPd.rHp.rrs != null) {
            int bsO = (int) bVar.bsO();
            this.rPd.rHp.rrs.b(this.rAC, bh.Wq(), this.qPf);
            this.rPd.rHp.rrs.a(this.rAC, bsO, true, this.qPf);
            this.rPd.rHp.rrs.z(this.rAC, this.rAC + ((long) this.hHw));
            this.rAA.qvN.a(null);
        }
    }
}
