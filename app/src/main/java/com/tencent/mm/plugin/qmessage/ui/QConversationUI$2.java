package com.tencent.mm.plugin.qmessage.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.qmessage.a;

class QConversationUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ QConversationUI pnT;

    QConversationUI$2(QConversationUI qConversationUI) {
        this.pnT = qConversationUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intent intent = new Intent();
        intent.putExtra("Contact_User", QConversationUI.a(this.pnT).field_username);
        intent.putExtra("Chat_Readonly", true);
        a.ifs.d(intent, this.pnT.mController.xIM);
        return true;
    }
}
