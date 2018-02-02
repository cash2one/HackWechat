package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;
import java.util.List;

class t$1 implements c {
    final /* synthetic */ List rto;
    final /* synthetic */ List rtp;
    final /* synthetic */ t rtq;

    t$1(t tVar, List list, List list2) {
        this.rtq = tVar;
        this.rto = list;
        this.rtp = list2;
    }

    public final void a(n nVar) {
        nVar.clear();
        for (int i = 0; i < this.rto.size(); i++) {
            nVar.f(((Integer) this.rtp.get(i)).intValue(), (CharSequence) this.rto.get(i));
        }
        nVar.f(-1, this.rtq.context.getString(j.qKs));
    }
}
