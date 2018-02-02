package com.tencent.mm.plugin.scanner.ui;

import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelstat.o;

class q$1 implements a {
    final /* synthetic */ q pYI;

    q$1(q qVar) {
        this.pYI = qVar;
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        if (!z) {
            return true;
        }
        q.a(this.pYI, f2);
        q.b(this.pYI, f);
        q.a(this.pYI, (int) d2);
        q.a(this.pYI, "");
        q.b(this.pYI, "");
        q.b(this.pYI, i);
        q.a(this.pYI);
        q.b(this.pYI);
        if (!q.c(this.pYI)) {
            q.d(this.pYI);
            o.a(2012, f, f2, (int) d2);
        }
        return false;
    }
}
