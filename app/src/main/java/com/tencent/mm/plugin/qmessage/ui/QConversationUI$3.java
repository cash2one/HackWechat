package com.tencent.mm.plugin.qmessage.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class QConversationUI$3 implements OnCancelListener {
    final /* synthetic */ QConversationUI pnT;

    QConversationUI$3(QConversationUI qConversationUI) {
        this.pnT = qConversationUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        QConversationUI.h(this.pnT);
    }
}
