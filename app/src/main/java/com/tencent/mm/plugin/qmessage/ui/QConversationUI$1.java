package com.tencent.mm.plugin.qmessage.ui;

import com.tencent.mm.ui.o.a;
import com.tencent.mm.z.s;
import com.tencent.mm.z.t;

class QConversationUI$1 implements a {
    final /* synthetic */ QConversationUI pnT;

    QConversationUI$1(QConversationUI qConversationUI) {
        this.pnT = qConversationUI;
    }

    public final void Xv() {
        QConversationUI qConversationUI = this.pnT;
        String AP = QConversationUI.a(this.pnT).AP();
        int hv = t.hv(s.hfm);
        if (hv <= 0) {
            qConversationUI.setMMTitle(AP);
        } else {
            qConversationUI.setMMTitle(AP + "(" + hv + ")");
        }
        QConversationUI.a(this.pnT, QConversationUI.b(this.pnT).getCount());
    }

    public final void Xw() {
    }
}
