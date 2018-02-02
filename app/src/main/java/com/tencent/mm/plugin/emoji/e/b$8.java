package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.g.a.mg;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;

class b$8 extends c<mg> {
    final /* synthetic */ b lvv;

    b$8(b bVar) {
        this.lvv = bVar;
        this.xen = mg.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        mg mgVar = (mg) bVar;
        if (!(mgVar == null || !(mgVar instanceof mg) || mgVar.fEd == null)) {
            String str = mgVar.fEd.fqV;
            if (!bh.ov(str) && i.aBE().lwM.XP(str)) {
                i.aBz().aAN();
            }
        }
        return false;
    }
}
