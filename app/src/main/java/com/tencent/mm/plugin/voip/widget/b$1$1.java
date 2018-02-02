package com.tencent.mm.plugin.voip.widget;

import com.tencent.mm.plugin.voip.widget.b.1;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class b$1$1 implements a {
    final /* synthetic */ 1 svL;

    b$1$1(1 1) {
        this.svL = 1;
    }

    public final boolean uF() {
        x.i("MicroMsg.Voip.VoipSmallWindow", "click small view and time is up we remove it..");
        b.b(this.svL.svK);
        if (b.c(this.svL.svK) != null) {
            b.c(this.svL.svK).TG();
        }
        return true;
    }
}
