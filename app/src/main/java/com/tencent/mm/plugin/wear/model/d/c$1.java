package com.tencent.mm.plugin.wear.model.d;

import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements a {
    final /* synthetic */ c tiK;

    c$1(c cVar) {
        this.tiK = cVar;
    }

    public final boolean uF() {
        long bN = ((long) e.bN(this.tiK.filename)) - ((long) this.tiK.tiH);
        x.d("MicroMsg.Wear.NetSceneVoiceToText", "onTimerExpired: filename=%s | fileLength=%d | readOffset=%d | isRecordFinished=%b | canReadLength=%d", new Object[]{this.tiK.filename, Long.valueOf((long) e.bN(this.tiK.filename)), Integer.valueOf(this.tiK.tiH), Boolean.valueOf(this.tiK.hWy), Long.valueOf(bN)});
        if (bN < 3300 && !this.tiK.hWy) {
            return true;
        }
        if (this.tiK.hWy && bN <= 0) {
            return false;
        }
        if (this.tiK.a(this.tiK.hmA, this.tiK.gJT) == -1) {
            this.tiK.gJT.a(3, -1, "doScene failed", this.tiK);
        }
        return false;
    }
}
