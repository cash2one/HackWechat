package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.g.a.og;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;

class c$13 implements Runnable {
    final /* synthetic */ c yyQ;

    public c$13(c cVar) {
        this.yyQ = cVar;
    }

    public final void run() {
        b ogVar = new og();
        ogVar.fGf.userName = this.yyQ.kEC.field_username;
        a.xef.m(ogVar);
    }
}
