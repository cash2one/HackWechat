package com.tencent.mm.plugin.qmessage.ui;

import android.view.View;
import com.tencent.mm.ui.base.MMSlideDelView.f;

class QConversationUI$7 implements f {
    final /* synthetic */ QConversationUI pnT;

    QConversationUI$7(QConversationUI qConversationUI) {
        this.pnT = qConversationUI;
    }

    public final void t(View view, int i) {
        QConversationUI.c(this.pnT).performItemClick(view, i, 0);
    }
}
