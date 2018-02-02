package com.tencent.mm.ui.bizchat;

import android.database.Cursor;
import com.tencent.mm.ag.a.b;
import com.tencent.mm.ag.y;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba.a;
import com.tencent.mm.z.c;

class BizChatConversationUI$a$8 implements a {
    final /* synthetic */ long hfa;
    final /* synthetic */ BizChatConversationUI.a ynJ;

    BizChatConversationUI$a$8(BizChatConversationUI.a aVar, long j) {
        this.ynJ = aVar;
        this.hfa = j;
    }

    public final boolean HB() {
        return BizChatConversationUI.a.n(this.ynJ);
    }

    public final void HA() {
        int i = 0;
        if (BizChatConversationUI.a.o(this.ynJ) != null) {
            y.Mh().aT(this.hfa);
            y.Mi().aT(this.hfa);
            b Mi = y.Mi();
            String a = BizChatConversationUI.a.a(this.ynJ);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("select count(*) from BizChatConversation");
            stringBuilder.append(" where brandUserName = '").append(a).append("' ");
            Cursor a2 = Mi.gJP.a(stringBuilder.toString(), null, 2);
            if (a2 != null) {
                if (a2.moveToFirst()) {
                    i = a2.getInt(0);
                }
                a2.close();
            }
            if (i <= 0) {
                ar.Hg();
                c.Fd().WX(BizChatConversationUI.a.a(this.ynJ));
            }
            BizChatConversationUI.a.o(this.ynJ).dismiss();
        }
    }
}
