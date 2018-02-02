package com.tencent.mm.plugin.chatroom.ui;

import com.tencent.mm.pluginsdk.q.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h$c;

class ChatroomInfoUI$13 implements h$c {
    final /* synthetic */ ChatroomInfoUI lal;

    ChatroomInfoUI$13(ChatroomInfoUI chatroomInfoUI) {
        this.lal = chatroomInfoUI;
    }

    public final void jl(int i) {
        switch (i) {
            case 0:
                x.d("MicroMsg.ChatroomInfoUI", "dz[dealQuitChatRoom owner click room_owner_delete_direct]");
                ChatroomInfoUI.y(this.lal);
                if (a.vcx != null) {
                    a.vcx.Fr(ChatroomInfoUI.b(this.lal));
                    return;
                }
                return;
            default:
                x.d("MicroMsg.ChatroomInfoUI", "dz[dealQuitChatRoom owner click cancel]");
                return;
        }
    }
}
