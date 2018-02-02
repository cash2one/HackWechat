package com.tencent.mm.plugin.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class ChatroomInfoUI$a implements OnCancelListener {
    ChatroomInfoUI$a() {
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ChatroomInfoUI.ei(true);
    }
}
