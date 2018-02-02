package com.tencent.mm.plugin.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.chatroom.ui.DelChatroomMemberUI.a.1;
import com.tencent.mm.storage.x;

class DelChatroomMemberUI$a$1$1 implements OnClickListener {
    final /* synthetic */ x laS;
    final /* synthetic */ 1 laT;

    DelChatroomMemberUI$a$1$1(1 1, x xVar) {
        this.laT = 1;
        this.laS = xVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        DelChatroomMemberUI.a(this.laT.laR.laP, this.laS.field_username);
    }
}
