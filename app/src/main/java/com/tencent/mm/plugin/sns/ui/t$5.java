package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;
import java.util.List;

class t$5 implements c {
    final /* synthetic */ List lnl;
    final /* synthetic */ t rtq;
    final /* synthetic */ List rtt;

    t$5(t tVar, List list, List list2) {
        this.rtq = tVar;
        this.lnl = list;
        this.rtt = list2;
    }

    public final void a(n nVar) {
        nVar.clear();
        for (int i = 0; i < this.lnl.size(); i++) {
            nVar.f(((Integer) this.rtt.get(i)).intValue(), (CharSequence) this.lnl.get(i));
        }
    }
}
