package com.tencent.mm.plugin.qmessage.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.bh;

class QConversationUI$13 implements OnMenuItemClickListener {
    final /* synthetic */ QConversationUI pnT;

    QConversationUI$13(QConversationUI qConversationUI) {
        this.pnT = qConversationUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (!bh.ov(QConversationUI.f(this.pnT))) {
            QConversationUI.a(this.pnT, QConversationUI.f(this.pnT), QConversationUI.g(this.pnT));
        }
        return true;
    }
}
