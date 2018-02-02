package com.tencent.mm.plugin.chatroom.ui;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;

class ChatroomInfoUI$29 implements Runnable {
    final /* synthetic */ ChatroomInfoUI lal;

    ChatroomInfoUI$29(ChatroomInfoUI chatroomInfoUI) {
        this.lal = chatroomInfoUI;
    }

    public final void run() {
        ChatroomInfoUI chatroomInfoUI = this.lal;
        ar.Hg();
        ChatroomInfoUI.a(chatroomInfoUI, c.Fh().hD(ChatroomInfoUI.b(this.lal)));
        if (ChatroomInfoUI.c(this.lal) == null) {
            x.e("MicroMsg.ChatroomInfoUI", "member is null");
        } else if (bh.ov(ChatroomInfoUI.c(this.lal).field_roomowner)) {
            x.e("MicroMsg.ChatroomInfoUI", "roomowner is null");
        } else {
            ChatroomInfoUI.C(this.lal).sendEmptyMessage(0);
            ChatroomInfoUI.c(this.lal, ChatroomInfoUI.c(this.lal).field_roomowner.equals(q.FS()));
            ChatroomInfoUI.m(this.lal).St(ChatroomInfoUI.c(this.lal).field_roomowner);
        }
    }

    public final String toString() {
        return super.toString() + "|onNotifyChange";
    }
}
