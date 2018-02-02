package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;
import java.util.List;

class FlipView$2 implements c {
    final /* synthetic */ List msj;
    final /* synthetic */ FlipView rsJ;
    final /* synthetic */ List rsK;

    FlipView$2(FlipView flipView, List list, List list2) {
        this.rsJ = flipView;
        this.msj = list;
        this.rsK = list2;
    }

    public final void a(n nVar) {
        nVar.clear();
        for (int i = 0; i < this.msj.size(); i++) {
            nVar.f(((Integer) this.rsK.get(i)).intValue(), (CharSequence) this.msj.get(i));
        }
    }
}
