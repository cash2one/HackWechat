package com.tencent.mm.plugin.appbrand.media;

import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class f$5 implements a {
    final /* synthetic */ f jzQ;

    f$5(f fVar) {
        this.jzQ = fVar;
    }

    public final boolean uF() {
        x.i("MicroMsg.AudioRecordMgr", "timer, onTimerExpired to stop record");
        this.jzQ.vi();
        return true;
    }
}
