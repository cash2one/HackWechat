package com.tencent.mm.e.b;

import com.tencent.mm.e.b.b.b;
import com.tencent.mm.sdk.platformtools.x;

class j$1 implements b {
    final /* synthetic */ j fmi;

    j$1(j jVar) {
        this.fmi = jVar;
    }

    public final void onError() {
        j.a(this.fmi).zd();
        if (j.b(this.fmi) != null) {
            j.b(this.fmi).onError();
        }
        try {
            j.c(this.fmi).release();
            j.d(this.fmi);
        } catch (Exception e) {
            x.e("MicroMsg.SimpleVoiceRecorder", "setErrorListener File[" + this.fmi.fileName + "] ErrMsg[" + e.getStackTrace() + "]");
        }
    }
}
