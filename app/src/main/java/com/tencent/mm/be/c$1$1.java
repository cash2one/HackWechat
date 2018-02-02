package com.tencent.mm.be;

import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.be.c.1;
import com.tencent.mm.sdk.platformtools.x;

class c$1$1 implements IdleHandler {
    final /* synthetic */ 1 hPc;

    c$1$1(1 1) {
        this.hPc = 1;
    }

    public final boolean queueIdle() {
        x.d("MicroMsg.SpeexEncoderWorker", "queueIdle  ");
        e.SL().b(this.hPc.hPb);
        return false;
    }
}
