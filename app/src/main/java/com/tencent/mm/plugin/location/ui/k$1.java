package com.tencent.mm.plugin.location.ui;

import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class k$1 implements a {
    final /* synthetic */ k nUL;

    k$1(k kVar) {
        this.nUL = kVar;
    }

    public final boolean uF() {
        x.i("MicroMsg.TalkMgr", "onSeizeMicSuccess expired to execute");
        this.nUL.aVY();
        return false;
    }
}
