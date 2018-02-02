package com.tencent.mm.pluginsdk.i.a.b;

import com.tencent.mm.pluginsdk.i.a.d.o.a;
import com.tencent.mm.pluginsdk.i.a.d.q;

class b$1 implements Runnable {
    final /* synthetic */ int vgr;
    final /* synthetic */ int vgs;
    final /* synthetic */ int vgt;
    final /* synthetic */ boolean vgu;
    final /* synthetic */ b vgv;

    b$1(b bVar, int i, int i2, int i3, boolean z) {
        this.vgv = bVar;
        this.vgr = i;
        this.vgs = i2;
        this.vgt = i3;
        this.vgu = z;
    }

    public final void run() {
        q RW = a.bZC().RW(i.ey(this.vgr, this.vgs));
        if (RW == null) {
            return;
        }
        if (-1 == this.vgt || String.valueOf(this.vgt).equals(RW.field_fileVersion)) {
            RW.field_needRetry = !this.vgu;
            a.bZC().e(RW);
        }
    }
}
