package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.sdk.platformtools.ak.a;

class e$6 implements a {
    final /* synthetic */ e skv;

    e$6(e eVar) {
        this.skv = eVar;
    }

    public final boolean uF() {
        if (this.skv.mStatus == 4) {
            com.tencent.mm.plugin.voip.b.a.et("MicroMsg.Voip.VoipContext", "connect time out.. now finish..");
            this.skv.ske.spH.skR = 105;
            this.skv.p(1, -9000, "");
        }
        return false;
    }
}
