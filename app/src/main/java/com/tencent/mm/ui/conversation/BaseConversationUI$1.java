package com.tencent.mm.ui.conversation;

import com.tencent.mm.modelstat.d;

class BaseConversationUI$1 implements Runnable {
    final /* synthetic */ boolean yVW;
    final /* synthetic */ BaseConversationUI yVX;

    BaseConversationUI$1(BaseConversationUI baseConversationUI, boolean z) {
        this.yVX = baseConversationUI;
        this.yVW = z;
    }

    public final void run() {
        d.b(3, this.yVW ? "ChattingUI" + BaseConversationUI.access$000(this.yVX).csL() : this.yVX.getLocalClassName(), this.yVW ? BaseConversationUI.access$000(this.yVX).hashCode() : this.yVX.hashCode());
    }
}
