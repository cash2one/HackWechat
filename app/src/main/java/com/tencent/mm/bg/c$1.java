package com.tencent.mm.bg;

import com.tencent.mm.a.e;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements a {
    final /* synthetic */ c hYj;

    c$1(c cVar) {
        this.hYj = cVar;
    }

    public final boolean uF() {
        long bN = (long) e.bN(this.hYj.filename);
        x.d("MicroMsg.NetSceneVoiceAddr", g.zh() + " onTimerExpired: file:" + this.hYj.filename + " nowlen:" + bN + " oldoff:" + this.hYj.hOX + " isFin:" + this.hYj.hWy);
        if (bN - ((long) this.hYj.hOX) < 3300 && !this.hYj.hWy) {
            return true;
        }
        if (this.hYj.a(this.hYj.hmA, this.hYj.gJT) == -1) {
            this.hYj.retCode = g.getLine() + 40000;
            this.hYj.gJT.a(3, -1, "doScene failed", this.hYj);
        }
        return false;
    }
}
