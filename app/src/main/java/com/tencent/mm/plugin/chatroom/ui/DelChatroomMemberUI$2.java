package com.tencent.mm.plugin.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.chatroom.d.g;
import com.tencent.mm.z.ar;

class DelChatroomMemberUI$2 implements OnCancelListener {
    final /* synthetic */ DelChatroomMemberUI laP;
    final /* synthetic */ g lar;

    DelChatroomMemberUI$2(DelChatroomMemberUI delChatroomMemberUI, g gVar) {
        this.laP = delChatroomMemberUI;
        this.lar = gVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.lar);
    }
}
