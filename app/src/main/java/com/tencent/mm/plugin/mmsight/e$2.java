package com.tencent.mm.plugin.mmsight;

import com.tencent.mm.g.a.qe;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.plugin.mmsight.model.l;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class e$2 extends c<qe> {
    final /* synthetic */ e oqV;

    e$2(e eVar) {
        this.oqV = eVar;
        this.xen = qe.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        qe qeVar = (qe) bVar;
        if (l.a(qeVar.fHN.fHA, d.MU().MW(), qeVar.fHN.fHP, qeVar.fHN.fHR)) {
            qeVar.fHN.fHQ.run();
            qeVar.fHO.result = l.b(qeVar.fHN.fHA, d.MU().MW(), qeVar.fHN.fHP, qeVar.fHN.fHR);
        } else {
            qeVar.fHO.result = 1;
        }
        return false;
    }
}
