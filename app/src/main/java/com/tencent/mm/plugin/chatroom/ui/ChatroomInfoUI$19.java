package com.tencent.mm.plugin.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.chatroom.d.g;
import com.tencent.mm.z.ar;

class ChatroomInfoUI$19 implements OnCancelListener {
    final /* synthetic */ ChatroomInfoUI lal;
    final /* synthetic */ g lar;

    ChatroomInfoUI$19(ChatroomInfoUI chatroomInfoUI, g gVar) {
        this.lal = chatroomInfoUI;
        this.lar = gVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.lar);
    }
}
