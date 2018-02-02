package com.tencent.mm.plugin.voip_cs.b.a;

import com.tencent.mm.plugin.voip_cs.b.b;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements a {
    final /* synthetic */ b sxB;

    b$1(b bVar) {
        this.sxB = bVar;
    }

    public final boolean uF() {
        x.i("MicroMsg.voipcs.VoipCSViewManager", "voipcs invite time out!opposite not responese");
        b.bIU().bjS = 1;
        this.sxB.za(6);
        return true;
    }
}
