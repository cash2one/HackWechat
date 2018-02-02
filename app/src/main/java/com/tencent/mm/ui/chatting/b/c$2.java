package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.ag.a.e;

class c$2 implements Runnable {
    final /* synthetic */ c yyQ;

    c$2(c cVar) {
        this.yyQ = cVar;
    }

    public final void run() {
        if (this.yyQ.vnK && this.yyQ.fhr.csy() != null && !this.yyQ.fhr.csy().ytm) {
            e.d(this.yyQ.ync);
        }
    }
}
