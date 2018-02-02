package com.tencent.mm.booter;

import com.tencent.mm.g.a.mu;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class a$2 extends c<mu> {
    final /* synthetic */ a gxN;

    a$2(a aVar) {
        this.gxN = aVar;
        this.xen = mu.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        switch (((mu) bVar).fES.state) {
            case 0:
                x.d("MicroMsg.BackgroundPlayer", "jacks record resume event");
                this.gxN.wB();
                break;
            case 1:
                x.d("MicroMsg.BackgroundPlayer", "jacks record pause event");
                this.gxN.wA();
                break;
        }
        return false;
    }
}
