package com.tencent.mm.pluginsdk.ui.chat;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class ChatFooter$3 implements OnClickListener {
    final /* synthetic */ ChatFooter vra;

    ChatFooter$3(ChatFooter chatFooter) {
        this.vra = chatFooter;
    }

    public final synchronized void onClick(View view) {
        String obj = ChatFooter.a(this.vra).getText().toString();
        x.d("MicroMsg.ChatFooter", "send msg onClick");
        if (obj.trim().length() == 0 && obj.length() != 0) {
            x.d("MicroMsg.ChatFooter", "empty message cant be sent");
            if (ChatFooter.l(this.vra) == null || !ChatFooter.l(this.vra).isShowing()) {
                ChatFooter.a(this.vra, h.h(this.vra.getContext(), R.l.dQN, R.l.dGO));
            }
        } else if (ChatFooter.j(this.vra).Eg(obj)) {
            ChatFooter.a(this.vra).clearComposingText();
            ChatFooter.a(this.vra).setText("");
        }
    }
}
