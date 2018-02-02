package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.mm.sdk.platformtools.bh;

class a$8 implements Runnable {
    final /* synthetic */ a jPj;
    final /* synthetic */ i jPp;

    a$8(a aVar, i iVar) {
        this.jPj = aVar;
        this.jPp = iVar;
    }

    public final void run() {
        if (!bh.cA(a.a(this.jPj))) {
            int size = a.a(this.jPj).size();
            a.a(this.jPj).clear();
            a.b(this.jPj).X(0, size);
        }
        a.a(this.jPj).addAll(this.jPp);
        a.b(this.jPj).W(0, this.jPp.size());
    }
}
