package com.tencent.mm.plugin.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.chatroom.ui.RoomInfoDetailUI.2;

class RoomInfoDetailUI$2$2 implements OnClickListener {
    final /* synthetic */ 2 lbY;

    RoomInfoDetailUI$2$2(2 2) {
        this.lbY = 2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        RoomInfoDetailUI.a(this.lbY.lbX, true);
        Intent intent = new Intent();
        intent.putExtra("Chat_User", RoomInfoDetailUI.a(this.lbY.lbX).field_username);
        intent.addFlags(67108864);
        d.a(this.lbY.lbX, ".ui.chatting.ChattingUI", intent);
    }
}
