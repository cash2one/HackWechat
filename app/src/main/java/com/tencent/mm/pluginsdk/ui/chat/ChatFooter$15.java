package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.mm.R;
import com.tencent.mm.bv.a;

class ChatFooter$15 implements Runnable {
    final /* synthetic */ ChatFooter vra;

    ChatFooter$15(ChatFooter chatFooter) {
        this.vra = chatFooter;
    }

    public final void run() {
        if (ChatFooter.D(this.vra) != null) {
            ChatFooter.D(this.vra).dismiss();
            ChatFooter.E(this.vra).setVisibility(0);
            ChatFooter.F(this.vra).setVisibility(8);
            ChatFooter.G(this.vra).setVisibility(8);
            ChatFooter.w(this.vra).setVisibility(8);
            ChatFooter.v(this.vra).setVisibility(0);
        }
        ChatFooter.r(this.vra).setBackgroundDrawable(a.b(this.vra.getContext(), R.g.bFg));
        ChatFooter.r(this.vra).setText(R.l.dQt);
        ChatFooter.d(this.vra, false);
        ChatFooter.c(this.vra, false);
    }
}
