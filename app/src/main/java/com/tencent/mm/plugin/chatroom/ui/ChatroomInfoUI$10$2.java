package com.tencent.mm.plugin.chatroom.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.chatroom.ui.ChatroomInfoUI.10;
import com.tencent.mm.plugin.report.service.g;

class ChatroomInfoUI$10$2 implements OnClickListener {
    final /* synthetic */ 10 lan;
    final /* synthetic */ ProgressDialog lao;

    ChatroomInfoUI$10$2(10 10, ProgressDialog progressDialog) {
        this.lan = 10;
        this.lao = progressDialog;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g.pQN.h(14553, new Object[]{Integer.valueOf(3), Integer.valueOf(3), ChatroomInfoUI.b(this.lan.lal)});
        this.lao.show();
        ChatroomInfoUI.a(this.lan.lal, false);
        ChatroomInfoUI.a(this.lan.lal, this.lao);
    }
}
