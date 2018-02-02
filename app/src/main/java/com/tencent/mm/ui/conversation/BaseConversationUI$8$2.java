package com.tencent.mm.ui.conversation;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.conversation.BaseConversationUI.8;
import com.tencent.mm.ui.tools.TestTimeForChatting.a;

class BaseConversationUI$8$2 implements a {
    final /* synthetic */ 8 yVY;

    BaseConversationUI$8$2(8 8) {
        this.yVY = 8;
    }

    public final void cnA() {
        x.i("MicroMsg.BaseConversationUI", "[onDrawed]");
        this.yVY.start = System.currentTimeMillis();
        if (BaseConversationUI.access$000(this.yVY.yVX).getSwipeBackLayout() != null) {
            BaseConversationUI.access$000(this.yVY.yVX).getSwipeBackLayout().startAnimation(BaseConversationUI.access$700(this.yVY.yVX));
        } else {
            BaseConversationUI.access$000(this.yVY.yVX).getView().startAnimation(BaseConversationUI.access$700(this.yVY.yVX));
        }
        BaseConversationUI.access$100(this.yVY.yVX).zno = null;
    }
}
