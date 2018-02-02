package com.tencent.mm.ui.bizchat;

import android.view.MenuItem;
import com.tencent.mm.ag.y;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.bizchat.BizChatConversationUI.a;

class BizChatConversationUI$a$15 implements d {
    final /* synthetic */ a ynJ;

    BizChatConversationUI$a$15(a aVar) {
        this.ynJ = aVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        com.tencent.mm.ag.a.a aS;
        switch (menuItem.getItemId()) {
            case 0:
                a.a(this.ynJ, a.d(this.ynJ));
                return;
            case 1:
                aS = y.Mi().aS(a.d(this.ynJ));
                aS.field_unReadCount = 1;
                aS.field_atCount = 0;
                y.Mi().b(aS);
                b.hPA.I(aS.field_brandUserName, true);
                return;
            case 2:
                y.Mi().aU(a.d(this.ynJ));
                b.hPA.I(y.Mi().aS(a.d(this.ynJ)).field_brandUserName, false);
                return;
            case 3:
                aS = y.Mi().aS(a.d(this.ynJ));
                if (y.Mi().aV(a.d(this.ynJ))) {
                    y.Mi().aX(a.d(this.ynJ));
                    b.hPA.c(true, aS.field_brandUserName, false);
                    return;
                }
                y.Mi().aW(a.d(this.ynJ));
                b.hPA.c(true, aS.field_brandUserName, true);
                return;
            default:
                return;
        }
    }
}
