package com.tencent.mm.ui.bizchat;

import com.tencent.mm.ag.a.d$a$b;
import com.tencent.mm.ag.a.d.a;
import com.tencent.mm.ag.y;
import com.tencent.mm.sdk.platformtools.x;

class BizChatroomInfoUI$3 implements a {
    final /* synthetic */ BizChatroomInfoUI yoK;

    BizChatroomInfoUI$3(BizChatroomInfoUI bizChatroomInfoUI) {
        this.yoK = bizChatroomInfoUI;
    }

    public final void a(d$a$b com_tencent_mm_ag_a_d_a_b) {
        if (com_tencent_mm_ag_a_d_a_b != null && com_tencent_mm_ag_a_d_a_b.hqQ != null && com_tencent_mm_ag_a_d_a_b.hqF == BizChatroomInfoUI.g(this.yoK) && com_tencent_mm_ag_a_d_a_b.hqP != a.a.hqM) {
            x.i("MicroMsg.BizChatroomInfoUI", "bizChatExtension bizChat change");
            BizChatroomInfoUI.a(this.yoK, y.Mh().ag(BizChatroomInfoUI.g(this.yoK)));
            BizChatroomInfoUI.h(this.yoK);
        }
    }
}
