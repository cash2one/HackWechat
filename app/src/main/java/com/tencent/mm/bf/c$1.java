package com.tencent.mm.bf;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class c$1 implements Runnable {
    final /* synthetic */ c hSX;

    c$1(c cVar) {
        this.hSX = cVar;
    }

    public final void run() {
        x.v("MicroMsg.FMessageConversationStorage", "onNotifyChange, newCount update to = %d", new Object[]{Integer.valueOf(this.hSX.Tl())});
        ar.Hg();
        c.CU().set(143618, Integer.valueOf(r0));
    }
}
