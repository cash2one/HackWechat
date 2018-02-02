package com.tencent.mm.plugin.chatroom.ui;

import com.tencent.mm.z.ak;
import com.tencent.mm.z.ak.b.a;

class ChatroomInfoUI$30 implements Runnable {
    final /* synthetic */ a laC;
    final /* synthetic */ ChatroomInfoUI lal;

    ChatroomInfoUI$30(ChatroomInfoUI chatroomInfoUI, a aVar) {
        this.lal = chatroomInfoUI;
        this.laC = aVar;
    }

    public final void run() {
        ak.a.hfL.a(ChatroomInfoUI.c(this.lal).field_chatroomname, "", this.laC);
    }

    public final String toString() {
        return super.toString() + "|getContactCallBack2";
    }
}
