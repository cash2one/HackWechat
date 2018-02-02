package com.tencent.mm.plugin.card.a;

import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements a {
    final /* synthetic */ c kIG;

    c$1(c cVar) {
        this.kIG = cVar;
    }

    public final boolean uF() {
        x.i("MicroMsg.CardCodeMgr", "onTimerExpired, do request code");
        this.kIG.vV(this.kIG.kIw);
        this.kIG.atP();
        return true;
    }
}
