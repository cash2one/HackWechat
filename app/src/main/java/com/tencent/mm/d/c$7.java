package com.tencent.mm.d;

import com.tencent.mm.cache.a;
import com.tencent.mm.view.b.a$b;

class c$7 implements a$b {
    final /* synthetic */ c fiO;

    public c$7(c cVar) {
        this.fiO = cVar;
    }

    public final void uY() {
        this.fiO.uR().set(((a) this.fiO.uI()).gBw);
        this.fiO.uT();
        c.a(this.fiO, 300, false, false);
    }

    public final void onStart() {
        c.a(this.fiO, false);
    }
}
