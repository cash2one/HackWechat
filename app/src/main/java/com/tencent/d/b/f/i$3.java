package com.tencent.d.b.f;

import com.tencent.d.a.c.c;
import com.tencent.d.b.b.a;
import com.tencent.d.b.e.b;
import com.tencent.d.b.e.d;

class i$3 implements b<d.b> {
    final /* synthetic */ i AdM;

    i$3(i iVar) {
        this.AdM = iVar;
    }

    public final /* synthetic */ void cx(Object obj) {
        c.i("Soter.TaskInit", "soter: got support tag from backend: %b", new Object[]{Boolean.valueOf(((d.b) obj).fIP)});
        synchronized (a.class) {
            a.cFX().nU(r6.fIP);
            a.cFX().cFY();
        }
        this.AdM.b(new com.tencent.d.b.a.d(0));
    }
}
