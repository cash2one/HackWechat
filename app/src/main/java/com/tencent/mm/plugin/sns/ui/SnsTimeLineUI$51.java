package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.pn;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class SnsTimeLineUI$51 extends c<pn> {
    final /* synthetic */ SnsTimeLineUI rIN;

    SnsTimeLineUI$51(SnsTimeLineUI snsTimeLineUI) {
        this.rIN = snsTimeLineUI;
        this.xen = pn.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        pn pnVar = (pn) bVar;
        if (SnsTimeLineUI.g(this.rIN) != null) {
            com.tencent.mm.plugin.sns.h.b bVar2 = SnsTimeLineUI.g(this.rIN).rrt.qWT;
            String str = pnVar.fHp.fHq;
            bVar2.rcP.add(pnVar.fHp.fzW);
            bVar2.rcX.add(str);
            bVar2.rbA = bVar2.rcX.size();
        }
        return false;
    }
}
