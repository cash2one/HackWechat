package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.qb;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class SnsTimeLineUI$52 extends c<qb> {
    final /* synthetic */ SnsTimeLineUI rIN;

    SnsTimeLineUI$52(SnsTimeLineUI snsTimeLineUI) {
        this.rIN = snsTimeLineUI;
        this.xen = qb.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        qb qbVar = (qb) bVar;
        if (SnsTimeLineUI.g(this.rIN) != null) {
            com.tencent.mm.plugin.sns.h.b bVar2;
            if (qbVar.fHH.fHI) {
                bVar2 = SnsTimeLineUI.g(this.rIN).rrt.qWT;
                bVar2.rcZ.add(qbVar.fHH.username);
                bVar2.rbC = bVar2.rcZ.size();
            } else {
                bVar2 = SnsTimeLineUI.g(this.rIN).rrt.qWT;
                bVar2.rda.add(qbVar.fHH.username);
                bVar2.rbD = bVar2.rda.size();
            }
        }
        return false;
    }
}
