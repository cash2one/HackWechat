package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.mm.plugin.mmsight.model.a.a.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class r$1 implements a {
    final /* synthetic */ r owj;

    r$1(r rVar) {
        this.owj = rVar;
    }

    public final void output(byte[] bArr) {
        long Wq = bh.Wq();
        boolean baq = this.owj.owa.baq();
        r rVar = this.owj;
        boolean z = baq && this.owj.fke;
        rVar.d(bArr, z);
        j.ouM.D(bArr);
        x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "markStop: %s isEnd %s costTime %d", new Object[]{Boolean.valueOf(this.owj.fke), Boolean.valueOf(baq), Long.valueOf(bh.bA(Wq))});
        if (baq && this.owj.fke) {
            this.owj.baT();
        }
    }
}
