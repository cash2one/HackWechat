package com.tencent.mm.plugin.qmessage.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;

class QConversationUI$12 implements OnClickListener {
    final /* synthetic */ QConversationUI pnT;

    QConversationUI$12(QConversationUI qConversationUI) {
        this.pnT = qConversationUI;
    }

    public final void onClick(View view) {
        c.a(QConversationUI.c(this.pnT));
    }
}
