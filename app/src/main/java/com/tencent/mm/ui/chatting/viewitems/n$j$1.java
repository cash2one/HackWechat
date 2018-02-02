package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.viewitems.n.a;
import com.tencent.mm.ui.chatting.viewitems.n.j;
import com.tencent.mm.ui.chatting.viewitems.n.j.c;
import com.tencent.mm.y.m;

class n$j$1 implements c {
    final /* synthetic */ au heR;
    final /* synthetic */ n.c yLi;
    final /* synthetic */ a yLj;
    final /* synthetic */ int yLk;
    final /* synthetic */ j yLl;
    final /* synthetic */ m yrK;

    n$j$1(j jVar, n.c cVar, a aVar, m mVar, au auVar, int i) {
        this.yLl = jVar;
        this.yLi = cVar;
        this.yLj = aVar;
        this.yrK = mVar;
        this.heR = auVar;
        this.yLk = i;
    }

    public final void onFinish() {
        j.a(this.yLl, this.yLi, this.yLj, this.yrK, this.heR, this.yLk);
    }
}
