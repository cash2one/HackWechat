package com.tencent.mm.ui.conversation;

import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.v;

class BaseConversationUI$4 implements IdleHandler {
    final /* synthetic */ BaseConversationUI yVX;

    BaseConversationUI$4(BaseConversationUI baseConversationUI) {
        this.yVX = baseConversationUI;
    }

    public final boolean queueIdle() {
        long currentTimeMillis = System.currentTimeMillis();
        if (BaseConversationUI.access$100(this.yVX) == null) {
            if (BaseConversationUI.access$200(this.yVX) == null) {
                BaseConversationUI.access$202(this.yVX, v.fv(this.yVX).inflate(R.i.dcT, null));
            }
            if (BaseConversationUI.access$300(this.yVX) == null) {
                BaseConversationUI.access$302(this.yVX, v.fv(this.yVX).inflate(R.i.cZW, null));
            }
        }
        x.d("MicroMsg.BaseConversationUI", "prepare chattingUI view use %dms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return false;
    }
}
