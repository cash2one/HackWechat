package com.tencent.mm.ui.chatting;

import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.conversation.BaseConversationUI;

class ChattingUI$a$18 implements Runnable {
    final /* synthetic */ a ywR;

    ChattingUI$a$18(a aVar) {
        this.ywR = aVar;
    }

    public final void run() {
        boolean z = true;
        if (this.ywR.isCurrentActivity) {
            a.p(this.ywR);
        } else if (this.ywR.thisActivity() instanceof LauncherUI) {
            LauncherUI launcherUI = (LauncherUI) this.ywR.thisActivity();
            if (launcherUI != null) {
                if (this.ywR.isSupportNavigationSwipeBack()) {
                    z = false;
                }
                launcherUI.closeChatting(z);
            }
        } else if (this.ywR.thisActivity() instanceof BaseConversationUI) {
            BaseConversationUI baseConversationUI = (BaseConversationUI) this.ywR.thisActivity();
            if (baseConversationUI != null) {
                if (this.ywR.isSupportNavigationSwipeBack()) {
                    z = false;
                }
                baseConversationUI.closeChatting(z);
            }
        }
    }
}
