package com.tencent.mm.plugin.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.chatroom.d.k;
import com.tencent.mm.plugin.chatroom.ui.SeeRoomMemberUI.12;
import com.tencent.mm.z.ar;

class SeeRoomMemberUI$12$1 implements OnCancelListener {
    final /* synthetic */ k lax;
    final /* synthetic */ 12 ldg;

    SeeRoomMemberUI$12$1(12 12, k kVar) {
        this.ldg = 12;
        this.lax = kVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.lax);
    }
}
