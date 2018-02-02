package com.tencent.mm.plugin.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class RoomCardUI$8 implements OnClickListener {
    final /* synthetic */ RoomCardUI lbL;

    RoomCardUI$8(RoomCardUI roomCardUI) {
        this.lbL = roomCardUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.lbL.setResult(0);
        this.lbL.finish();
    }
}
