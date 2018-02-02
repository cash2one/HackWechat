package com.tencent.mm.bg;

import com.tencent.mm.a.e;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class d$1 implements a {
    final /* synthetic */ d hYl;

    d$1(d dVar) {
        this.hYl = dVar;
    }

    public final boolean uF() {
        long bN = (long) e.bN(this.hYl.filename);
        x.d("MicroMsg.NetSceneVoiceInput", g.zh() + " onTimerExpired: file:" + this.hYl.filename + " nowlen:" + bN + " oldoff:" + this.hYl.hOX + " isFin:" + this.hYl.hWy);
        if (bN - ((long) this.hYl.hOX) < 3300 && !this.hYl.hWy) {
            return true;
        }
        if (this.hYl.a(this.hYl.hmA, this.hYl.gJT) == -1) {
            this.hYl.retCode = g.getLine() + 40000;
            this.hYl.gJT.a(3, -1, "doScene failed", this.hYl);
        }
        return false;
    }
}
