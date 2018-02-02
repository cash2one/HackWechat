package com.tencent.mm.modelmulti;

import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.r.3;
import com.tencent.mm.modelmulti.r.b;
import com.tencent.mm.modelmulti.r.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class r$f$1 implements b {
    final /* synthetic */ f hHF;

    r$f$1(f fVar) {
        this.hHF = fVar;
    }

    public final boolean ie(int i) {
        x.i("MicroMsg.SyncService", "%s onFinishCmd resp:%s pushSycnFlag:%s recvTime:%s", this.hHF, this.hHF.hHr, Integer.valueOf(this.hHF.hEY), Long.valueOf(this.hHF.hHE));
        if ((this.hHF.hEY & 1) > 0) {
            g.Dk();
            g.CG().a(new h(this.hHF.hHE, bh.VD(bh.ou((String) g.Dj().CU().get(8195, null)))), 0);
        }
        g.Dm().F(new 3(this.hHF.hHn, this.hHF));
        return true;
    }
}
