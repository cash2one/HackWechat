package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.ag.e.a.b;
import com.tencent.mm.ag.f;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.chatting.b.c.12;

class c$12$1 implements Runnable {
    final /* synthetic */ x rAD;
    final /* synthetic */ b yyT;
    final /* synthetic */ 12 yyU;

    c$12$1(12 12, b bVar, x xVar) {
        this.yyU = 12;
        this.yyT = bVar;
        this.rAD = xVar;
    }

    public final void run() {
        if (this.yyU.yyQ.fhr.csr() && this.yyT.hog.equals(this.yyU.yyQ.fhr.crz())) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.BizMgr", "try to refresh footer.");
            this.yyU.yyQ.fhr.U(this.rAD);
            this.yyU.yyQ.kEC = f.jS(this.yyT.hog);
            this.yyU.yyQ.ywe.W(this.rAD);
        }
    }
}
