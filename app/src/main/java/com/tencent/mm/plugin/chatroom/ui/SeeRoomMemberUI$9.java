package com.tencent.mm.plugin.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.chatroom.d.g;
import com.tencent.mm.z.ar;

class SeeRoomMemberUI$9 implements OnCancelListener {
    final /* synthetic */ g lar;
    final /* synthetic */ SeeRoomMemberUI lde;

    SeeRoomMemberUI$9(SeeRoomMemberUI seeRoomMemberUI, g gVar) {
        this.lde = seeRoomMemberUI;
        this.lar = gVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.lar);
    }
}
