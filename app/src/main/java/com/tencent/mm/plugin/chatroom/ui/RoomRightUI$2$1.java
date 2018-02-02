package com.tencent.mm.plugin.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.chatroom.d.j;
import com.tencent.mm.plugin.chatroom.ui.RoomRightUI.2;
import com.tencent.mm.z.ar;

class RoomRightUI$2$1 implements OnCancelListener {
    final /* synthetic */ j lcd;
    final /* synthetic */ 2 lce;

    RoomRightUI$2$1(2 2, j jVar) {
        this.lce = 2;
        this.lcd = jVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.lcd);
    }
}
