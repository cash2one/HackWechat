package com.tencent.mm.plugin.wenote.a;

import com.tencent.mm.g.a.lh;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wenote.model.d;
import com.tencent.mm.plugin.wenote.model.j;
import com.tencent.mm.protocal.c.vg;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends c<lh> {
    public b() {
        this.xen = lh.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
        lh lhVar = (lh) bVar;
        if (lhVar.fCF.fBV) {
            g.pQN.h(14789, new Object[]{Integer.valueOf(3)});
        } else {
            g.pQN.h(14789, new Object[]{Integer.valueOf(2)});
        }
        x.i("MicroMsg.OpenNoteFromSessionListener", "do OpenNoteFromSessionListener");
        d jVar = new j();
        com.tencent.mm.plugin.wenote.model.c.bVN().tQn = jVar;
        vg vgVar = new vg();
        vgVar.scene = lhVar.fCF.scene;
        jVar.a(lhVar.fCF.fCG, Long.valueOf(lhVar.fCF.fqm), lhVar.fCF.fBV, lhVar.fCF.context, 0, 0, vgVar);
        return false;
    }
}
