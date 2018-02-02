package com.tencent.mm.ui.chatting;

import com.tencent.mm.R;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;
import java.util.List;

class l$3 implements c {
    final /* synthetic */ List yrM;

    l$3(List list) {
        this.yrM = list;
    }

    public final void a(n nVar) {
        nVar.ai(1193046, R.l.euT, R.g.bAK);
        for (CharSequence add : this.yrM) {
            nVar.add(add);
        }
    }
}
