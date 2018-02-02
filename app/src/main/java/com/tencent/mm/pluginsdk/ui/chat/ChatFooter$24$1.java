package com.tencent.mm.pluginsdk.ui.chat;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.24;
import com.tencent.mm.z.q;

class ChatFooter$24$1 implements OnClickListener {
    final /* synthetic */ String vrc;
    final /* synthetic */ 24 vrd;

    ChatFooter$24$1(24 24, String str) {
        this.vrd = 24;
        this.vrc = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        int i2 = 1;
        boolean a = q.a(this.vrc, this.vrd.vra.vpS, true);
        ChatFooter chatFooter = this.vrd.vra;
        if (!a) {
            i2 = 0;
        }
        ChatFooter.a(chatFooter, i2, this.vrc);
    }
}
