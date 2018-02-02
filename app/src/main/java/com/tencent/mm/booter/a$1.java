package com.tencent.mm.booter;

import com.tencent.mm.sdk.platformtools.aq.a;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements a {
    final /* synthetic */ a gxN;

    a$1(a aVar) {
        this.gxN = aVar;
    }

    public final void fi(int i) {
        switch (i) {
            case 0:
                x.v("MicroMsg.BackgroundPlayer", "call end");
                this.gxN.wA();
                return;
            case 1:
            case 2:
                x.v("MicroMsg.BackgroundPlayer", "call start");
                this.gxN.wB();
                return;
            default:
                return;
        }
    }
}
