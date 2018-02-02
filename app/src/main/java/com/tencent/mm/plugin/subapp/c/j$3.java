package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class j$3 implements a {
    final /* synthetic */ j rWH;

    j$3(j jVar) {
        this.rWH = jVar;
    }

    public final boolean uF() {
        x.d("MicroMsg.VoiceRemindService", "onTimerExpired");
        try {
            j.h(this.rWH);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.VoiceRemindService", e, "", new Object[0]);
        }
        return false;
    }
}
