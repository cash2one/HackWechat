package com.tencent.mm.plugin.talkroom.model;

import com.tencent.mm.plugin.talkroom.b.e;
import com.tencent.mm.sdk.platformtools.aa.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class g$5 implements a {
    final /* synthetic */ g scg;

    g$5(g gVar) {
        this.scg = gVar;
    }

    public final boolean uF() {
        if (g.e(this.scg) == 0 || bh.ov(g.g(this.scg))) {
            x.w("MicroMsg.TalkRoomServer", "talkNoopTimer error: roomId %d, talkUsername %s", new Object[]{Integer.valueOf(g.e(this.scg)), g.g(this.scg)});
            g.h(this.scg);
            return false;
        }
        String g = g.g(this.scg);
        int e = g.e(this.scg);
        long f = g.f(this.scg);
        g gVar = this.scg;
        g.g(this.scg);
        ar.CG().a(new e(g, e, f, gVar.bEL()), 0);
        return true;
    }
}
