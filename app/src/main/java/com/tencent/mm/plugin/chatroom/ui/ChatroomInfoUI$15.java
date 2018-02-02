package com.tencent.mm.plugin.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class ChatroomInfoUI$15 implements OnCancelListener {
    final /* synthetic */ ChatroomInfoUI lal;

    ChatroomInfoUI$15(ChatroomInfoUI chatroomInfoUI) {
        this.lal = chatroomInfoUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ChatroomInfoUI.a(this.lal, true);
    }
}
