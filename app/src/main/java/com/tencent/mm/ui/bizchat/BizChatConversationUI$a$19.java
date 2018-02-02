package com.tencent.mm.ui.bizchat;

import com.tencent.mm.ui.o.a;
import com.tencent.mm.z.r;

class BizChatConversationUI$a$19 implements a {
    final /* synthetic */ BizChatConversationUI.a ynJ;

    BizChatConversationUI$a$19(BizChatConversationUI.a aVar) {
        this.ynJ = aVar;
    }

    public final void Xv() {
        this.ynJ.setMMTitle(r.gu(BizChatConversationUI.a.a(this.ynJ)));
        if (BizChatConversationUI.a.b(this.ynJ).getCount() <= 0) {
            BizChatConversationUI.a.h(this.ynJ).setVisibility(0);
            BizChatConversationUI.a.i(this.ynJ).setVisibility(8);
            return;
        }
        BizChatConversationUI.a.h(this.ynJ).setVisibility(8);
        if (BizChatConversationUI.a.i(this.ynJ) != null) {
            BizChatConversationUI.a.i(this.ynJ).setVisibility(0);
        }
    }

    public final void Xw() {
    }
}
