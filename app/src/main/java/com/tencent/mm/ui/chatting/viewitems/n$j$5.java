package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.viewitems.n.j;
import com.tencent.mm.ui.chatting.viewitems.n.j.c;

class n$j$5 implements c {
    final /* synthetic */ n.c yLi;
    final /* synthetic */ j yLl;

    n$j$5(j jVar, n.c cVar) {
        this.yLl = jVar;
        this.yLi = cVar;
    }

    public final void onFinish() {
        this.yLi.yKP.yKL.setVisibility(0);
        this.yLi.yKP.yKW.setVisibility(0);
        this.yLi.yKP.jpW.setTextColor(j.a(this.yLl).getContext().getResources().getColor(R.e.white));
        this.yLi.yKP.jMv.setBackgroundResource(R.k.dxB);
    }
}
