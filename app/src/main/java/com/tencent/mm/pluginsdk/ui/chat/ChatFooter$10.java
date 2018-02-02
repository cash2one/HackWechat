package com.tencent.mm.pluginsdk.ui.chat;

import android.view.KeyEvent;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.x;

class ChatFooter$10 implements a {
    final /* synthetic */ ChatFooter vra;

    ChatFooter$10(ChatFooter chatFooter) {
        this.vra = chatFooter;
    }

    public final void aXU() {
        ChatFooter.z(this.vra);
        ChatFooter.c(this.vra).setVisibility(0);
        ChatFooter.r(this.vra).setVisibility(8);
        ChatFooter.a(this.vra, true);
        ChatFooter.b(this.vra, R.g.bBp);
        if (ChatFooter.i(this.vra) != null) {
            ChatFooter.i(this.vra).performClick();
        }
    }

    public final void gw(boolean z) {
        ChatFooter.z(this.vra);
        ChatFooter.c(this.vra).setVisibility(0);
        ChatFooter.r(this.vra).setVisibility(8);
        ChatFooter.b(this.vra, R.g.bBp);
        if (ChatFooter.a(this.vra) != null) {
            this.vra.ll(z);
        }
    }

    public final void amZ() {
        ChatFooter.z(this.vra);
        ChatFooter.c(this.vra).setVisibility(0);
        ChatFooter.r(this.vra).setVisibility(8);
        ChatFooter.a(this.vra, true);
        ChatFooter.b(this.vra, R.g.bBp);
        ChatFooter.a(this.vra).ztO.sendKeyEvent(new KeyEvent(0, 67));
        ChatFooter.a(this.vra).ztO.sendKeyEvent(new KeyEvent(1, 67));
    }

    public final void append(String str) {
        ChatFooter.z(this.vra);
        ChatFooter.c(this.vra).setVisibility(0);
        ChatFooter.r(this.vra).setVisibility(8);
        ChatFooter.a(this.vra, true);
        ChatFooter.b(this.vra, R.g.bBp);
        try {
            ChatFooter.a(this.vra).aak(str);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ChatFooter", e, "", new Object[0]);
        }
    }
}
