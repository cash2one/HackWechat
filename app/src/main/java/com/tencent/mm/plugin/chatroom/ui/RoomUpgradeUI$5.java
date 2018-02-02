package com.tencent.mm.plugin.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.z.ar;

class RoomUpgradeUI$5 implements OnCancelListener {
    final /* synthetic */ RoomUpgradeUI lcy;

    RoomUpgradeUI$5(RoomUpgradeUI roomUpgradeUI) {
        this.lcy = roomUpgradeUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (RoomUpgradeUI.h(this.lcy) != null) {
            ar.CG().c(RoomUpgradeUI.h(this.lcy));
            RoomUpgradeUI.i(this.lcy);
        }
        this.lcy.finish();
    }
}
