package com.tencent.mm.ui.bizchat;

import com.tencent.mm.ag.a.d$a$b;
import com.tencent.mm.ag.a.d.a;
import com.tencent.mm.sdk.platformtools.x;

class BizChatConversationUI$a$13 implements a {
    final /* synthetic */ BizChatConversationUI.a ynJ;

    BizChatConversationUI$a$13(BizChatConversationUI.a aVar) {
        this.ynJ = aVar;
    }

    public final void a(d$a$b com_tencent_mm_ag_a_d_a_b) {
        if (com_tencent_mm_ag_a_d_a_b != null && com_tencent_mm_ag_a_d_a_b.hqQ != null && BizChatConversationUI.a.a(this.ynJ).equals(com_tencent_mm_ag_a_d_a_b.hqQ.field_brandUserName)) {
            x.i("MicroMsg.BizChatConversationFmUI", "bizChatExtension bizChat change");
            BizChatConversationUI.a.b(this.ynJ).fU(com_tencent_mm_ag_a_d_a_b.hqF);
            if (BizChatConversationUI.a.p(this.ynJ)) {
                BizChatConversationUI.a.b(this.ynJ).Xy();
            }
        }
    }
}
