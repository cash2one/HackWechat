package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.g.a.tj;
import com.tencent.mm.k.g;
import com.tencent.mm.plugin.wear.model.f.h;
import com.tencent.mm.plugin.wear.model.f.k;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class e$3 extends c<tj> {
    final /* synthetic */ e tik;

    e$3(e eVar) {
        this.tik = eVar;
        this.xen = tj.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        tj tjVar = (tj) bVar;
        switch (tjVar.fLO.action) {
            case 2:
                a.bOt().thN.a(new h(tjVar.fLP.fpG, tjVar.fLP.fLR, tjVar.fLP.fLS, tjVar.fLP.fLT));
                break;
            case 4:
                if (g.zY().getInt("WearPayBlock", 0) == 0) {
                    a.bOt().thN.a(new k(tjVar.fLO.fLQ, tjVar.fLO.content));
                    break;
                }
                break;
        }
        return false;
    }
}
