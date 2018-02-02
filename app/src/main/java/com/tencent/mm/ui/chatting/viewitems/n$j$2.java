package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.viewitems.n.c;
import com.tencent.mm.ui.chatting.viewitems.n.j;

class n$j$2 implements n$j$c {
    final /* synthetic */ int gIR;
    final /* synthetic */ c yLi;
    final /* synthetic */ j yLl;

    n$j$2(j jVar, int i, c cVar) {
        this.yLl = jVar;
        this.gIR = i;
        this.yLi = cVar;
    }

    public final void onFinish() {
        if (this.gIR > 1) {
            this.yLi.yKN.yKY.setTextColor(j.a(this.yLl).getContext().getResources().getColor(R.e.white));
            this.yLi.yKN.yKY.setBackgroundResource(R.g.bzw);
        }
        this.yLi.yKN.yKW.setVisibility(0);
    }
}
