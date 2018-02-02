package com.tencent.mm.modelmulti;

import com.tencent.mm.booter.f;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.r.b;
import com.tencent.mm.modelmulti.r.d;
import com.tencent.mm.sdk.platformtools.x;

class r$d$1 implements b {
    final /* synthetic */ int hHw;
    final /* synthetic */ d hHx;

    r$d$1(d dVar, int i) {
        this.hHx = dVar;
        this.hHw = i;
    }

    public final boolean ie(int i) {
        x.i("MicroMsg.SyncService", "%s onFinishCmd index:%s ", new Object[]{this.hHx, Integer.valueOf(this.hHw)});
        int i2 = this.hHw;
        g.Dk();
        g.Dh();
        f.aL(i2, a.Cg());
        r.b(this.hHx.hHn, this.hHx);
        return true;
    }
}
