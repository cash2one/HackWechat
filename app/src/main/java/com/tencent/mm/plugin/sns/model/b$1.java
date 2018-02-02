package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ae.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.a.f;
import com.tencent.mm.plugin.sns.model.b.b;

class b$1 implements Runnable {
    final /* synthetic */ b qSF;
    final /* synthetic */ b qSG;

    b$1(b bVar, b bVar2) {
        this.qSG = bVar;
        this.qSF = bVar2;
    }

    public final void run() {
        e eVar = this.qSG;
        eVar.gCl.add(this.qSF);
        int i = b.qSu + 1;
        b.qSu = i;
        if (i <= 1) {
            g.Dk();
            g.Di().gPJ.a(f.CTRL_INDEX, eVar);
        }
    }
}
