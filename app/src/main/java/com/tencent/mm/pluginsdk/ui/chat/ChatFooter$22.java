package com.tencent.mm.pluginsdk.ui.chat;

import android.os.Message;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.sdk.platformtools.af;

class ChatFooter$22 extends af {
    final /* synthetic */ ChatFooter vra;

    ChatFooter$22(ChatFooter chatFooter) {
        this.vra = chatFooter;
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 4097:
                ChatFooter.f(this.vra, true);
                LayoutParams layoutParams = ChatFooter.m(this.vra).getLayoutParams();
                int bottom = ChatFooter.m(this.vra).getBottom() - ChatFooter.m(this.vra).getTop();
                if (this.vra.cbN()) {
                    if (ChatFooter.n(this.vra) != null) {
                        ChatFooter.n(this.vra).setVisibility(8);
                    }
                    ChatFooter.J(this.vra).setVisibility(8);
                    ChatFooter.m(this.vra).setVisibility(4);
                }
                if (bottom <= 3) {
                    ChatFooter.f(this.vra, false);
                    ChatFooter.m(this.vra).setVisibility(8);
                    ChatFooter.c(this.vra, this.vra.cbR());
                    return;
                }
                layoutParams.height = Math.max(bottom - 60, 1);
                ChatFooter.m(this.vra).setLayoutParams(layoutParams);
                ChatFooter.K(this.vra);
                return;
            default:
                return;
        }
    }
}
