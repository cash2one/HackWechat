package com.tencent.d.b.f;

import com.tencent.d.a.c.f;
import com.tencent.d.b.a.a;
import com.tencent.d.b.e.b;
import com.tencent.d.b.e.c;

class h$1 implements b<c.b> {
    final /* synthetic */ h AdB;

    h$1(h hVar) {
        this.AdB = hVar;
    }

    public final /* synthetic */ void cx(Object obj) {
        c.b bVar = (c.b) obj;
        if (f.ov(bVar.mzI)) {
            com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: get challenge failed", new Object[0]);
            this.AdB.b(new a(19));
            return;
        }
        this.AdB.thp = bVar.mzI;
        this.AdB.cGl();
    }
}
