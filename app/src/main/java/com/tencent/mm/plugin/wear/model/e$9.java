package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.g.a.kk;
import com.tencent.mm.plugin.wear.model.f.f;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class e$9 extends c<kk> {
    final /* synthetic */ e tik;

    e$9(e eVar) {
        this.tik = eVar;
        this.xen = kk.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        kk kkVar = (kk) bVar;
        if (e.a(this.tik)) {
            a.bOt().thN.a(new f(kkVar.fBI.userName, kkVar.fBI.bgo, kkVar.fBI.type));
        }
        return false;
    }
}
