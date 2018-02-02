package com.tencent.mm.ui.conversation;

import com.tencent.mm.modelstat.d;
import com.tencent.mm.platformtools.t;

class BaseConversationUI$2 implements Runnable {
    final /* synthetic */ BaseConversationUI yVX;

    BaseConversationUI$2(BaseConversationUI baseConversationUI) {
        this.yVX = baseConversationUI;
    }

    public final void run() {
        d.b(4, "ChattingUI" + BaseConversationUI.access$000(this.yVX).csL(), BaseConversationUI.access$000(this.yVX).hashCode());
        d.f("ChattingUI" + BaseConversationUI.access$000(this.yVX).csL(), BaseConversationUI.access$500(this.yVX), t.Wo());
        d.b(3, this.yVX.getLocalClassName(), this.yVX.hashCode());
    }
}
