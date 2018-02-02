package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.R;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.viewitems.n.j;
import com.tencent.mm.ui.chatting.viewitems.n.j.c;

class n$j$4 implements c {
    final /* synthetic */ au heR;
    final /* synthetic */ n.c yLi;
    final /* synthetic */ j yLl;

    n$j$4(j jVar, n.c cVar, au auVar) {
        this.yLl = jVar;
        this.yLi = cVar;
        this.heR = auVar;
    }

    public final void onFinish() {
        this.yLi.yKR.yKL.setVisibility(0);
        if ((this.heR.field_msgId + "_0").equals(this.yLi.yIA)) {
            this.yLi.yKR.yKK.setImageResource(R.g.bBd);
        } else {
            this.yLi.yKR.yKK.setImageResource(R.g.bBe);
        }
    }
}
