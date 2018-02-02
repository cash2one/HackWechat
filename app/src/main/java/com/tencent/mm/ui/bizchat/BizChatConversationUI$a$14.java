package com.tencent.mm.ui.bizchat;

import com.tencent.mm.ag.c.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.g;

class BizChatConversationUI$a$14 implements a {
    final /* synthetic */ BizChatConversationUI.a ynJ;

    BizChatConversationUI$a$14(BizChatConversationUI.a aVar) {
        this.ynJ = aVar;
    }

    public final void a(a.a aVar) {
        String q = BizChatConversationUI.a.q(this.ynJ);
        if (aVar != null && !bh.ov(aVar.hog) && aVar.hog.equals(q)) {
            int k = BizChatConversationUI.a.k(this.ynJ);
            BizChatConversationUI.a.c(this.ynJ, g.bl(this.ynJ.getContext(), q));
            if (BizChatConversationUI.a.k(this.ynJ) != k) {
                BizChatConversationUI.a.r(this.ynJ);
            }
        }
    }
}
