package com.tencent.mm.plugin.chatroom.ui;

import android.view.View;
import com.tencent.mm.ui.base.preference.a;

class ChatroomInfoUI$34 implements Runnable {
    final /* synthetic */ int laD;
    final /* synthetic */ ChatroomInfoUI lal;

    ChatroomInfoUI$34(ChatroomInfoUI chatroomInfoUI, int i) {
        this.lal = chatroomInfoUI;
        this.laD = i;
    }

    public final void run() {
        View a = ((a) ChatroomInfoUI.f(this.lal)).a(this.laD, this.lal.nKG);
        if (a != null) {
            com.tencent.mm.ui.g.a.b(this.lal.mController.xIM, a);
        }
    }
}
