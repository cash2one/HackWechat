package com.tencent.mm.plugin.chatroom.ui;

import com.tencent.mm.z.ak.b.a;
import com.tencent.mm.z.ar;

class ChatroomInfoUI$22 implements a {
    final /* synthetic */ ChatroomInfoUI lal;

    ChatroomInfoUI$22(ChatroomInfoUI chatroomInfoUI) {
        this.lal = chatroomInfoUI;
    }

    public final void v(String str, boolean z) {
        if (z && ChatroomInfoUI.b(this.lal).equals(str)) {
            ar.Dm().F(new 1(this, str));
        }
    }
}
