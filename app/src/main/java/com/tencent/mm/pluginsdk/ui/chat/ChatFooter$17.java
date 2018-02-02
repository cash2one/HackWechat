package com.tencent.mm.pluginsdk.ui.chat;

import android.os.Message;
import com.tencent.mm.compatible.a.a.a;

class ChatFooter$17 implements a {
    final /* synthetic */ boolean jEp;
    final /* synthetic */ ChatFooter vra;

    ChatFooter$17(ChatFooter chatFooter, boolean z) {
        this.vra = chatFooter;
        this.jEp = z;
    }

    public final void run() {
        Message message = new Message();
        message.what = 1002;
        message.obj = Boolean.valueOf(this.jEp);
        ChatFooter.I(this.vra).sendMessage(message);
    }
}
