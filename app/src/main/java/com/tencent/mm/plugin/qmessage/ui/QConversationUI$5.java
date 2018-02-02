package com.tencent.mm.plugin.qmessage.ui;

import android.view.MenuItem;
import com.tencent.mm.ui.base.p.d;

class QConversationUI$5 implements d {
    final /* synthetic */ QConversationUI pnT;

    QConversationUI$5(QConversationUI qConversationUI) {
        this.pnT = qConversationUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        QConversationUI.a(this.pnT, QConversationUI.j(this.pnT));
    }
}
