package com.tencent.mm.ui.transmit;

import android.content.Intent;
import com.tencent.mm.pluginsdk.ui.applet.o.a;

class SelectConversationUI$15 implements a {
    final /* synthetic */ Intent val$intent;
    final /* synthetic */ SelectConversationUI zpv;

    SelectConversationUI$15(SelectConversationUI selectConversationUI, Intent intent) {
        this.zpv = selectConversationUI;
        this.val$intent = intent;
    }

    public final void a(boolean z, String str, int i) {
        this.zpv.aWs();
        if (z) {
            this.val$intent.putExtra("custom_send_text", str);
            SelectConversationUI.a(this.zpv, this.val$intent);
            this.zpv.finish();
        }
    }
}
