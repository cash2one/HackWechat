package com.tencent.mm.ui.conversation;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.conversation.BaseConversationUI.c;

class BaseConversationUI$c$1 implements Runnable {
    final /* synthetic */ c yWf;

    BaseConversationUI$c$1(c cVar) {
        this.yWf = cVar;
    }

    public final void run() {
        boolean z = true;
        String str = "MicroMsg.BaseConversationUI";
        String str2 = "on select image ActivityResult. after creat chattingUI, chatting fragment is null? %B";
        Object[] objArr = new Object[1];
        if (BaseConversationUI.access$000(this.yWf.yVX) != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.d(str, str2, objArr);
        if (BaseConversationUI.access$000(this.yWf.yVX) != null) {
            x.d("MicroMsg.BaseConversationUI", "on select image ActivityResult. do post activity result");
            BaseConversationUI.access$000(this.yWf.yVX).onActivityResult(this.yWf.fyV & 65535, this.yWf.bjW, this.yWf.fyW);
        }
    }

    public final String toString() {
        return super.toString() + "|PostSelectImageJob_onActivityResult";
    }
}
