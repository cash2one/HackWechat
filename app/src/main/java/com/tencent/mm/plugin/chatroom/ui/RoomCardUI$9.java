package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class RoomCardUI$9 implements OnClickListener {
    final /* synthetic */ RoomCardUI lbL;

    RoomCardUI$9(RoomCardUI roomCardUI) {
        this.lbL = roomCardUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        RoomCardUI roomCardUI = this.lbL;
        Context context = this.lbL.mController.xIM;
        this.lbL.getString(R.l.dGO);
        RoomCardUI.a(roomCardUI, h.a(context, this.lbL.getString(R.l.eGa), false, null));
        if (RoomCardUI.e(this.lbL)) {
            RoomCardUI.f(this.lbL);
            RoomCardUI.a(this.lbL, RoomCardUI.b(this.lbL).getText().toString());
        }
    }
}
