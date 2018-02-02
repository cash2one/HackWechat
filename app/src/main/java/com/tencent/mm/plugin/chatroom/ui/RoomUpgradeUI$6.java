package com.tencent.mm.plugin.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class RoomUpgradeUI$6 implements OnClickListener {
    final /* synthetic */ RoomUpgradeUI lcy;

    RoomUpgradeUI$6(RoomUpgradeUI roomUpgradeUI) {
        this.lcy = roomUpgradeUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.lcy.finish();
    }
}
