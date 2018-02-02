package com.tencent.mm.ui;

import com.tencent.mm.g.a.im;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;

class x$5 extends c<im> {
    final /* synthetic */ x xKV;

    x$5(x xVar) {
        this.xKV = xVar;
        this.xen = im.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        com.tencent.mm.blink.b.wo().f(new Runnable(this) {
            final /* synthetic */ x$5 xKW;

            {
                this.xKW = r1;
            }

            public final void run() {
                this.xKW.xKV.xKQ = true;
                ag.K(this.xKW.xKV.xKR);
                ag.y(this.xKW.xKV.xKR);
            }
        });
        return true;
    }
}
