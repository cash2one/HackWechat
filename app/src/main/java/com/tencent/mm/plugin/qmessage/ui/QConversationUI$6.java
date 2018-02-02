package com.tencent.mm.plugin.qmessage.ui;

import android.view.View;
import com.tencent.mm.ui.base.MMSlideDelView$c;

class QConversationUI$6 implements MMSlideDelView$c {
    final /* synthetic */ QConversationUI pnT;

    QConversationUI$6(QConversationUI qConversationUI) {
        this.pnT = qConversationUI;
    }

    public final int ci(View view) {
        return QConversationUI.c(this.pnT).getPositionForView(view);
    }
}
