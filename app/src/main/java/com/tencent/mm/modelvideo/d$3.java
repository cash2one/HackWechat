package com.tencent.mm.modelvideo;

import com.tencent.mm.sdk.platformtools.ak.a;

class d$3 implements a {
    final /* synthetic */ d hTX;

    d$3(d dVar) {
        this.hTX = dVar;
    }

    public final boolean uF() {
        if (this.hTX.a(this.hTX.hmA, this.hTX.gJT) == -1) {
            this.hTX.gJT.a(3, -1, "doScene failed", this.hTX);
        }
        return false;
    }
}
