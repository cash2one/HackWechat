package com.tencent.d.b.f;

import com.tencent.d.b.a.b;
import com.tencent.d.b.a.c;
import com.tencent.d.b.a.e;

class k$1 implements b<c> {
    final /* synthetic */ k AdU;

    k$1(k kVar) {
        this.AdU = kVar;
    }

    public final /* synthetic */ void a(e eVar) {
        c cVar = (c) eVar;
        com.tencent.d.a.c.c.d("Soter.TaskPrepareAuthKey", "soter: prepare ask end: %s", new Object[]{cVar.toString()});
        if (cVar.errCode == 0) {
            k.a(this.AdU);
        } else {
            this.AdU.b(cVar);
        }
    }
}
