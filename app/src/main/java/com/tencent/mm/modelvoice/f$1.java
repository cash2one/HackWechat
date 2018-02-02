package com.tencent.mm.modelvoice;

import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class f$1 implements a {
    final /* synthetic */ f hWE;

    f$1(f fVar) {
        this.hWE = fVar;
    }

    public final boolean uF() {
        p oc = q.oc(this.hWE.fileName);
        if (oc == null || !oc.UH()) {
            x.e("MicroMsg.NetSceneUploadVoice", "Get info Failed file:" + this.hWE.fileName);
            this.hWE.retCode = g.getLine() + 10000;
            this.hWE.gJT.a(3, -1, "doScene failed", this.hWE);
            return false;
        }
        if (!(3 == oc.status || 8 == oc.status)) {
            long currentTimeMillis = System.currentTimeMillis();
            if ((currentTimeMillis / 1000) - oc.hVF > 30) {
                x.e("MicroMsg.NetSceneUploadVoice", "Error ModifyTime in Read file:" + this.hWE.fileName);
                this.hWE.retCode = g.getLine() + 10000;
                this.hWE.gJT.a(3, -1, "doScene failed", this.hWE);
                return false;
            } else if (currentTimeMillis - this.hWE.hWD < 2000) {
                x.d("MicroMsg.NetSceneUploadVoice", "TimerExpired :" + this.hWE.fileName + " but last send time:" + (currentTimeMillis - this.hWE.hWD));
                return true;
            } else {
                g bp = q.nT(this.hWE.fileName).bp(oc.hUp, 6000);
                x.d("MicroMsg.NetSceneUploadVoice", "pusher doscene:" + this.hWE.fileName + " readByte:" + bp.flp + " stat:" + oc.status);
                if (bp.flp < MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                    return true;
                }
            }
        }
        if (this.hWE.a(this.hWE.hmA, this.hWE.gJT) != -1) {
            return false;
        }
        this.hWE.retCode = g.getLine() + 10000;
        this.hWE.gJT.a(3, -1, "doScene failed", this.hWE);
        return false;
    }
}
