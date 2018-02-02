package com.tencent.mm.plugin.chatroom.ui;

import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.applet.h;
import com.tencent.mm.protocal.c.aar;
import com.tencent.mm.vending.c.a;

class ChatroomInfoUI$31 implements a<Void, com.tencent.mm.ae.a.a<aar>> {
    final /* synthetic */ ChatroomInfoUI lal;

    ChatroomInfoUI$31(ChatroomInfoUI chatroomInfoUI) {
        this.lal = chatroomInfoUI;
    }

    public final /* synthetic */ Object call(Object obj) {
        com.tencent.mm.ae.a.a aVar = (com.tencent.mm.ae.a.a) obj;
        if (aVar == null) {
            return zBS;
        }
        int i = aVar.errType;
        int i2 = aVar.errCode;
        if (i == 0 && i2 == 0) {
            if (ChatroomInfoUI.c(this.lal) != null) {
                ChatroomInfoUI.a(this.lal, ChatroomInfoUI.c(this.lal).Ms().size());
            }
            if ((!ChatroomInfoUI.d(this.lal) && ChatroomInfoUI.e(this.lal) >= h.vnG) || (ChatroomInfoUI.d(this.lal) && ChatroomInfoUI.e(this.lal) >= h.vnG - 1)) {
                ChatroomInfoUI.f(this.lal).bk("see_room_member", false);
                ChatroomInfoUI.g(this.lal).setTitle(this.lal.getString(R.l.eJe));
            }
        }
        ChatroomInfoUI.h(this.lal);
        ChatroomInfoUI.i(this.lal);
        ChatroomInfoUI.j(this.lal);
        return zBS;
    }
}
