package com.tencent.mm.plugin.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.chatroom.d.k;
import com.tencent.mm.plugin.chatroom.ui.ChatroomInfoUI.21;
import com.tencent.mm.z.ar;

class ChatroomInfoUI$21$1 implements OnCancelListener {
    final /* synthetic */ k lax;
    final /* synthetic */ 21 lay;

    ChatroomInfoUI$21$1(21 21, k kVar) {
        this.lay = 21;
        this.lax = kVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.lax);
    }
}
