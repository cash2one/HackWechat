package com.tencent.mm.plugin.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.chatroom.d.d;
import com.tencent.mm.z.ar;

class ChatroomInfoUI$20 implements OnCancelListener {
    final /* synthetic */ ChatroomInfoUI lal;
    final /* synthetic */ d las;

    ChatroomInfoUI$20(ChatroomInfoUI chatroomInfoUI, d dVar) {
        this.lal = chatroomInfoUI;
        this.las = dVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.las);
    }
}
