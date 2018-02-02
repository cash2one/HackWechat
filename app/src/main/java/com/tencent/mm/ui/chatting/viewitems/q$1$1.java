package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;
import com.tencent.mm.ui.chatting.viewitems.q.1;

class q$1$1 implements c {
    final /* synthetic */ View jLA;
    final /* synthetic */ boolean yLI;
    final /* synthetic */ 1 yLJ;

    q$1$1(1 1, boolean z, View view) {
        this.yLJ = 1;
        this.yLI = z;
        this.jLA = view;
    }

    public final void a(n nVar) {
        if (this.yLI) {
            nVar.a(1, this.jLA.getResources().getColor(R.e.bsE), this.jLA.getResources().getString(R.l.ezB));
        } else {
            nVar.a(0, this.jLA.getResources().getColor(R.e.btC), this.jLA.getResources().getString(R.l.ezo));
        }
        nVar.add(0, 2, 0, this.jLA.getResources().getString(R.l.ezt));
    }
}
