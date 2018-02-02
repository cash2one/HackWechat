package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingTranslateView.a;
import com.tencent.mm.ui.chatting.b.ac.2;
import com.tencent.mm.ui.chatting.b.ac.3;

class ac$3$1 implements Runnable {
    final /* synthetic */ int toa;
    final /* synthetic */ String uR;
    final /* synthetic */ 3 yCA;

    ac$3$1(3 3, int i, String str) {
        this.yCA = 3;
        this.toa = i;
        this.uR = str;
    }

    public final void run() {
        if (this.toa == 0) {
            this.yCA.yCz.a(bh.VJ(this.uR), a.yvD);
            ac acVar = this.yCA.yCz;
            acVar.yCw.c(new 2(acVar, bh.VJ(this.uR)));
            return;
        }
        if (this.toa == 3) {
            h.bu(this.yCA.yCz.fhr.csq().getContext(), this.yCA.yCz.fhr.csq().getMMString(R.l.dTn));
        } else if (this.toa != 5) {
            h.bu(this.yCA.yCz.fhr.csq().getContext(), this.yCA.yCz.fhr.csq().getMMString(R.l.dTi));
        }
        this.yCA.yCz.a(bh.VJ(this.uR), a.yvB);
        this.yCA.yCz.fhr.cpl();
    }
}
