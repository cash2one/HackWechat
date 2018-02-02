package com.tencent.mm.pluginsdk.ui.chat;

import android.view.View;
import android.view.View.OnClickListener;

class ChatFooter$16 implements OnClickListener {
    final /* synthetic */ ChatFooter vra;

    ChatFooter$16(ChatFooter chatFooter) {
        this.vra = chatFooter;
    }

    public final void onClick(View view) {
        if (ChatFooter.H(this.vra) != null) {
            ChatFooter.H(this.vra).ln(false);
        }
    }
}
