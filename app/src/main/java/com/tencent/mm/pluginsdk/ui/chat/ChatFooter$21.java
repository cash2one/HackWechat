package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.mm.compatible.util.j;

class ChatFooter$21 implements Runnable {
    final /* synthetic */ ChatFooter vra;

    ChatFooter$21(ChatFooter chatFooter) {
        this.vra = chatFooter;
    }

    public final void run() {
        j.h(ChatFooter.b(this.vra));
    }
}
