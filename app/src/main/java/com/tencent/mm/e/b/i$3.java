package com.tencent.mm.e.b;

import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class i$3 implements a {
    final /* synthetic */ i fmc;

    i$3(i iVar) {
        this.fmc = iVar;
    }

    public final boolean uF() {
        x.d("MicroMsg.SceneVoiceService", "onTimerExpired");
        i.h(this.fmc);
        return false;
    }

    public final String toString() {
        return super.toString() + "|scenePusher";
    }
}
