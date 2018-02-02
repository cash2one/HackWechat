package com.tencent.mm.plugin.qmessage.ui;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMSlideDelView.e;

class QConversationUI$8 implements e {
    final /* synthetic */ QConversationUI pnT;

    QConversationUI$8(QConversationUI qConversationUI) {
        this.pnT = qConversationUI;
    }

    public final void bo(Object obj) {
        if (obj == null) {
            x.e("MicroMsg.QConversationUI", "onItemDel object null");
        } else {
            QConversationUI.a(this.pnT, obj.toString());
        }
    }
}
