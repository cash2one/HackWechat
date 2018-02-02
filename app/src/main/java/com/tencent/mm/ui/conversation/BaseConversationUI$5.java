package com.tencent.mm.ui.conversation;

import android.content.Intent;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;

class BaseConversationUI$5 implements IdleHandler {
    final /* synthetic */ BaseConversationUI yVX;

    BaseConversationUI$5(BaseConversationUI baseConversationUI) {
        this.yVX = baseConversationUI;
    }

    public final boolean queueIdle() {
        long currentTimeMillis = System.currentTimeMillis();
        if (BaseConversationUI.access$100(this.yVX) == null) {
            String FS;
            if (this.yVX.conversationFm == null || bh.ov(this.yVX.conversationFm.getUserName())) {
                FS = q.FS();
            } else {
                FS = this.yVX.conversationFm.getUserName();
            }
            BaseConversationUI.access$400(this.yVX, new Intent().putExtra("Chat_User", FS));
            BaseConversationUI.access$000(this.yVX).nWQ = true;
            BaseConversationUI.access$000(this.yVX).csJ();
            BaseConversationUI.access$100(this.yVX).setVisibility(8);
            BaseConversationUI.access$000(this.yVX).isPreLoaded = true;
            BaseConversationUI.access$000(this.yVX).onPause();
            BaseConversationUI.access$000(this.yVX).csH();
            BaseConversationUI.access$000(this.yVX).hHG = false;
            this.yVX.resumeMainFragment();
        }
        BaseConversationUI.access$202(this.yVX, null);
        BaseConversationUI.access$302(this.yVX, null);
        x.d("MicroMsg.BaseConversationUI", "prepare chattingUI logic use %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        return false;
    }
}
