package com.tencent.mm.plugin.chatroom.ui;

import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.applet.o.a;

class ChatroomInfoUI$35 implements a {
    final /* synthetic */ String laE;
    final /* synthetic */ ChatroomInfoUI lal;

    ChatroomInfoUI$35(ChatroomInfoUI chatroomInfoUI, String str) {
        this.lal = chatroomInfoUI;
        this.laE = str;
    }

    public final void a(boolean z, String str, int i) {
        if (z) {
            ChatroomInfoUI.a(this.lal, this.laE, str, R.l.epZ);
        }
    }
}
