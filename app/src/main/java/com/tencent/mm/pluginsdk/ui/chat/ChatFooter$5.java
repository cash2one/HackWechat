package com.tencent.mm.pluginsdk.ui.chat;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.z.q;

class ChatFooter$5 implements OnClickListener {
    final /* synthetic */ ChatFooter vra;

    ChatFooter$5(ChatFooter chatFooter) {
        this.vra = chatFooter;
    }

    public final void onClick(View view) {
        this.vra.cbn();
        if (q.GA().booleanValue() && this.vra.vqp != null) {
            this.vra.vqp.a(Boolean.valueOf(true), Boolean.valueOf(true));
        }
    }
}
