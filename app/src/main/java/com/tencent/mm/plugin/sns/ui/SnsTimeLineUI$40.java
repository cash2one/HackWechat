package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;

class SnsTimeLineUI$40 implements c {
    final /* synthetic */ SnsTimeLineUI rIN;

    SnsTimeLineUI$40(SnsTimeLineUI snsTimeLineUI) {
        this.rIN = snsTimeLineUI;
    }

    public final void a(n nVar) {
        if (!r.ien) {
            nVar.f(3, this.rIN.getString(j.dEW));
        }
        nVar.f(1, this.rIN.getString(j.dFa));
    }
}
