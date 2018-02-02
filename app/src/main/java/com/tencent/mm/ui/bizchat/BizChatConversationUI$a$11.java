package com.tencent.mm.ui.bizchat;

import com.tencent.mm.ag.a.b$a$b;
import com.tencent.mm.ag.a.b.a;
import com.tencent.mm.sdk.platformtools.x;

class BizChatConversationUI$a$11 implements a {
    final /* synthetic */ BizChatConversationUI.a ynJ;

    BizChatConversationUI$a$11(BizChatConversationUI.a aVar) {
        this.ynJ = aVar;
    }

    public final void a(b$a$b com_tencent_mm_ag_a_b_a_b) {
        if (com_tencent_mm_ag_a_b_a_b != null && com_tencent_mm_ag_a_b_a_b.hqG != null && BizChatConversationUI.a.a(this.ynJ).equals(com_tencent_mm_ag_a_b_a_b.hqG.field_brandUserName)) {
            x.i("MicroMsg.BizChatConversationFmUI", "bizChatExtension bizChatConv change");
            BizChatConversationUI.a.b(this.ynJ).fU(com_tencent_mm_ag_a_b_a_b.hqF);
            if (BizChatConversationUI.a.p(this.ynJ)) {
                BizChatConversationUI.a.b(this.ynJ).Xy();
            }
        }
    }
}
