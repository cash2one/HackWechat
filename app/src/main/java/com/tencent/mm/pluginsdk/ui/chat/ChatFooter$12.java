package com.tencent.mm.pluginsdk.ui.chat;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;

class ChatFooter$12 extends af {
    final /* synthetic */ ChatFooter vra;

    ChatFooter$12(ChatFooter chatFooter) {
        this.vra = chatFooter;
    }

    @SuppressLint({"NewApi"})
    @TargetApi(11)
    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1002:
                if (ChatFooter.a(this.vra) != null && message.obj != null) {
                    boolean booleanValue = ((Boolean) message.obj).booleanValue();
                    if (booleanValue) {
                        ChatFooter.a(this.vra).setAlpha(1.0f);
                    } else {
                        ChatFooter.a(this.vra).setAlpha(0.5f);
                    }
                    ChatFooter.a(this.vra, booleanValue);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
