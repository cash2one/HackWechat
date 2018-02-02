package com.tencent.mm.modelvoice;

import com.tencent.mm.e.b.b.b;
import com.tencent.mm.sdk.platformtools.x;

class t$1 implements b {
    final /* synthetic */ t hXQ;

    t$1(t tVar) {
        this.hXQ = tVar;
    }

    public final void onError() {
        if (t.a(this.hXQ) != null) {
            t.a(this.hXQ).onError();
        }
        try {
            t.b(this.hXQ).release();
            t.c(this.hXQ);
        } catch (Exception e) {
            x.e("VoiceRecorder", "setErrorListener File[" + this.hXQ.fileName + "] ErrMsg[" + e.getStackTrace() + "]");
        }
    }
}
