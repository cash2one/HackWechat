package com.tencent.mm.an;

import com.tencent.mm.an.c.4;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.ak.b.a;

class c$4$1 implements Runnable {
    final /* synthetic */ String fhl;
    final /* synthetic */ String hyI;
    final /* synthetic */ boolean hyJ;
    final /* synthetic */ 4 hyK;

    c$4$1(4 4, String str, String str2, boolean z) {
        this.hyK = 4;
        this.fhl = str;
        this.hyI = str2;
        this.hyJ = z;
    }

    public final void run() {
        a aVar = (a) this.hyK.hyF.hyx.remove(this.fhl);
        a aVar2 = bh.ov(this.hyI) ? null : (a) this.hyK.hyF.hyx.remove(this.hyI);
        if (aVar != null) {
            aVar.v(this.fhl, this.hyJ);
        }
        if (aVar2 != null && !bh.ov(this.hyI)) {
            aVar2.v(this.hyI, this.hyJ);
        }
    }
}
