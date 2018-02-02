package com.tencent.mm.be;

import com.tencent.mm.a.e;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements a {
    final /* synthetic */ a hOZ;

    a$1(a aVar) {
        this.hOZ = aVar;
    }

    public final boolean uF() {
        x.d("MicroMsg.NetSceneUploadMedia", g.zh() + " onTimerExpired: file:" + this.hOZ.filename + " nowlen:" + ((long) e.bN(this.hOZ.filename)) + " oldoff:" + this.hOZ.hOX);
        if (this.hOZ.a(this.hOZ.hmA, this.hOZ.gJT) == -1) {
            this.hOZ.gJT.a(3, -1, "doScene failed", this.hOZ);
        }
        return false;
    }
}
