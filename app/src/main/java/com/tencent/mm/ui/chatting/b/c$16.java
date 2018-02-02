package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.R;
import com.tencent.mm.l.a;

class c$16 implements Runnable {
    final /* synthetic */ c yyQ;

    public c$16(c cVar) {
        this.yyQ = cVar;
    }

    public final void run() {
        if (!a.fZ(this.yyQ.fhr.csi().field_type) && this.yyQ.fhr.csi().cia()) {
            this.yyQ.fhr.csq().setMMSubTitle(R.l.dQD);
        }
    }
}
