package com.tencent.mm.ui.conversation;

import android.view.MenuItem;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.conversation.EnterpriseConversationUI.a;

class EnterpriseConversationUI$a$4 implements d {
    final /* synthetic */ a yZh;

    EnterpriseConversationUI$a$4(a aVar) {
        this.yZh = aVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 1:
                a.a(this.yZh, a.g(this.yZh));
                return;
            case 2:
                a.b(this.yZh, a.g(this.yZh));
                return;
            case 3:
                a.ZH(a.g(this.yZh));
                return;
            default:
                return;
        }
    }
}
