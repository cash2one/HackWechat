package com.tencent.mm.ui.bizchat;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.ag.c;
import com.tencent.mm.ag.y;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.bizchat.BizChatConversationUI.a;
import com.tencent.mm.ui.bizchat.BizChatConversationUI.a.5;
import com.tencent.mm.ui.g;

class BizChatConversationUI$a$5$2 implements d {
    final /* synthetic */ 5 ynK;

    BizChatConversationUI$a$5$2(5 5) {
        this.ynK = 5;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        Intent intent;
        switch (menuItem.getItemId()) {
            case 1:
                a.l(this.ynK.ynJ);
                return;
            case 2:
                g.n(this.ynK.ynJ.getContext(), a.a(this.ynK.ynJ), 6);
                return;
            case 3:
                if (bh.ov(a.c(this.ynK.ynJ))) {
                    a.a(this.ynK.ynJ, y.Mf().jK(a.a(this.ynK.ynJ)).Lm());
                }
                if (!bh.ov(a.c(this.ynK.ynJ)) && y.Mp().jw(a.c(this.ynK.ynJ))) {
                    y.Mm();
                    c.a(a.c(this.ynK.ynJ), null);
                }
                intent = new Intent();
                intent.putExtra("Contact_User", a.a(this.ynK.ynJ));
                com.tencent.mm.bm.d.b(this.ynK.ynJ.thisActivity(), "profile", ".ui.ContactInfoUI", intent);
                return;
            case 4:
                if (bh.ov(a.a(this.ynK.ynJ))) {
                    x.e("MicroMsg.BizChatConversationFmUI", "brandUserName null");
                    return;
                }
                intent = new Intent(this.ynK.ynJ.getContext(), BizChatFavUI.class);
                intent.putExtra("Contact_User", a.a(this.ynK.ynJ));
                intent.addFlags(67108864);
                this.ynK.ynJ.startActivity(intent);
                return;
            default:
                return;
        }
    }
}
