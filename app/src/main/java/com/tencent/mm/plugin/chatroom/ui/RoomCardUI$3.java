package com.tencent.mm.plugin.chatroom.ui;

import android.view.View;
import android.view.View.OnLongClickListener;

class RoomCardUI$3 implements OnLongClickListener {
    final /* synthetic */ RoomCardUI lbL;

    RoomCardUI$3(RoomCardUI roomCardUI) {
        this.lbL = roomCardUI;
    }

    public final boolean onLongClick(View view) {
        RoomCardUI.a(this.lbL, RoomCardUI.b(this.lbL));
        return true;
    }
}
