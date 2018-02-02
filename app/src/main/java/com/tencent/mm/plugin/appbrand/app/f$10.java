package com.tencent.mm.plugin.appbrand.app;

import com.tencent.mm.g.a.iz;
import com.tencent.mm.plugin.appbrand.task.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class f$10 extends c<iz> {
    final /* synthetic */ f iDI;

    f$10(f fVar) {
        this.iDI = fVar;
        this.xen = iz.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        switch (((iz) bVar).fzC.aAk) {
            case 1:
            case 3:
                d.lv(1);
                break;
            default:
                d.lv(0);
                break;
        }
        com.tencent.mm.plugin.appbrand.dynamic.h.b.adh();
        return true;
    }
}
