package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.mm.pluginsdk.ui.chat.m.a;

class ChatFooter$1 implements a {
    final /* synthetic */ ChatFooter vra;

    ChatFooter$1(ChatFooter chatFooter) {
        this.vra = chatFooter;
    }

    public final void clear() {
        ChatFooter chatFooter = this.vra;
        if (chatFooter.okv != null) {
            chatFooter.okv.setText("");
        }
    }
}
