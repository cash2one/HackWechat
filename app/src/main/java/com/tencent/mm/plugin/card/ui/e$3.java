package com.tencent.mm.plugin.card.ui;

import android.os.Message;
import com.tencent.mm.plugin.card.b.d;
import com.tencent.mm.plugin.card.ui.e.b;
import com.tencent.mm.plugin.card.ui.e.c;
import com.tencent.mm.sdk.platformtools.af;

class e$3 extends af {
    final /* synthetic */ e kRr;

    e$3(e eVar) {
        this.kRr = eVar;
    }

    public final void handleMessage(Message message) {
        if (message.obj != null && (message.obj instanceof c)) {
            c cVar = (c) message.obj;
            if (cVar.kRA == b.kRy) {
                if (this.kRr.kQT != null) {
                    d.a(this.kRr.kQM, cVar.fnL, false);
                    this.kRr.kQT.awZ();
                }
            } else if (cVar.kRA == b.kRw) {
                if (this.kRr.kQT != null) {
                    this.kRr.kQT.d(com.tencent.mm.plugin.card.b.c.kXr);
                }
            } else if (this.kRr.kQT != null) {
                this.kRr.kQT.d(cVar.kRB);
            }
        }
    }
}
