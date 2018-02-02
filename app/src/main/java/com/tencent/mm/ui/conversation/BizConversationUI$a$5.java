package com.tencent.mm.ui.conversation;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.conversation.BizConversationUI.a;

class BizConversationUI$a$5 implements e {
    final /* synthetic */ a yWk;

    BizConversationUI$a$5(a aVar) {
        this.yWk = aVar;
    }

    public final void bo(Object obj) {
        if (obj == null) {
            x.e("MicroMsg.BizConversationUI", "onItemDel object null");
            return;
        }
        a.b(this.yWk, obj.toString());
    }
}
