package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class e$1 implements a {
    final /* synthetic */ e skv;

    e$1(e eVar) {
        this.skv = eVar;
    }

    public final boolean uF() {
        x.v("MicroMsg.Voip.VoipContext", "voip repeat sync");
        this.skv.skh.a(null, false, 7);
        return true;
    }
}
