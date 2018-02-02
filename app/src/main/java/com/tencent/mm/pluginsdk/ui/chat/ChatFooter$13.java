package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.mm.pluginsdk.ui.chat.n.a;
import com.tencent.mm.sdk.platformtools.x;

class ChatFooter$13 implements a {
    final /* synthetic */ ChatFooter vra;

    ChatFooter$13(ChatFooter chatFooter) {
        this.vra = chatFooter;
    }

    public final void bTZ() {
        ChatFooter.B(this.vra);
    }

    public final void Px(String str) {
        if (ChatFooter.j(this.vra) != null) {
            ChatFooter.j(this.vra).Eg(str);
        } else {
            x.e("MicroMsg.ChatFooter", "onSendMsg listener is null !!!");
        }
        ChatFooter.C(this.vra).reset();
    }

    public final void ky(boolean z) {
        if (z) {
            if (this.vra.vqq != null) {
                x.d("MicroMsg.ChatFooter", "onVoiceStart start");
                this.vra.vqq.g(Boolean.valueOf(true));
            }
        } else if (this.vra.vqq != null) {
            x.d("MicroMsg.ChatFooter", "onVoiceStart end");
            this.vra.vqq.g(Boolean.valueOf(false));
        }
    }
}
