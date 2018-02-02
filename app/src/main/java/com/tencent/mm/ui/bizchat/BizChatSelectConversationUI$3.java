package com.tencent.mm.ui.bizchat;

import android.content.Intent;
import com.tencent.mm.pluginsdk.ui.applet.o.a;

class BizChatSelectConversationUI$3 implements a {
    final /* synthetic */ long hfa;
    final /* synthetic */ String hpU;
    final /* synthetic */ BizChatSelectConversationUI yoC;

    BizChatSelectConversationUI$3(BizChatSelectConversationUI bizChatSelectConversationUI, String str, long j) {
        this.yoC = bizChatSelectConversationUI;
        this.hpU = str;
        this.hfa = j;
    }

    public final void a(boolean z, String str, int i) {
        if (z) {
            Intent intent = new Intent();
            intent.putExtra("enterprise_biz_name", this.hpU);
            intent.putExtra("key_biz_chat_id", this.hfa);
            intent.putExtra("key_is_biz_chat", true);
            this.yoC.setResult(-1, intent);
            this.yoC.finish();
        }
    }
}
