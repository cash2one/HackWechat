package com.tencent.mm.plugin.chatroom.ui;

import com.tencent.mm.plugin.chatroom.ui.ChatroomInfoUI.22;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class ChatroomInfoUI$22$1 implements Runnable {
    final /* synthetic */ String gIT;
    final /* synthetic */ 22 laz;

    ChatroomInfoUI$22$1(22 22, String str) {
        this.laz = 22;
        this.gIT = str;
    }

    public final void run() {
        ar.Hg();
        c.Fh().l(this.gIT, System.currentTimeMillis());
    }

    public final String toString() {
        return super.toString() + "|getContactCallBack";
    }
}
