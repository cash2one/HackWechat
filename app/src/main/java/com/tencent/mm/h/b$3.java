package com.tencent.mm.h;

import com.tencent.mm.g.a.rs;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;

class b$3 implements Runnable {
    final /* synthetic */ b gBd;
    final /* synthetic */ rs gBf;

    b$3(b bVar, rs rsVar) {
        this.gBd = bVar;
        this.gBf = rsVar;
    }

    public final void run() {
        x.i("MicroMsg.BroadcastController", "summerdiz handleEventOOB publish uiEvent");
        a.xef.m(this.gBf);
    }
}
