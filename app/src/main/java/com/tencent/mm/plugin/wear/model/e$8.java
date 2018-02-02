package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.g.a.tm;
import com.tencent.mm.plugin.wear.model.f.l;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class e$8 extends c<tm> {
    final /* synthetic */ e tik;

    e$8(e eVar) {
        this.tik = eVar;
        super(0);
        this.xen = tm.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        switch (((tm) bVar).fMb.fpr) {
            case 5:
                a.bOt().thN.a(new l(20011, ""));
                break;
            case 6:
            case 7:
                a.bOt().thN.a(new l(20012, ""));
                break;
        }
        return false;
    }
}
