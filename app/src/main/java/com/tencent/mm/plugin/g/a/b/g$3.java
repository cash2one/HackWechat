package com.tencent.mm.plugin.g.a.b;

import com.tencent.mm.plugin.g.a.b.g.a;

class g$3 implements Runnable {
    final /* synthetic */ g kxS;
    final /* synthetic */ int kxT;

    g$3(g gVar, int i) {
        this.kxS = gVar;
        this.kxT = i;
    }

    public final void run() {
        for (int i = 0; i < g.a(this.kxS).size(); i++) {
            ((a) g.a(this.kxS).get(i)).ne(this.kxT);
        }
    }
}
