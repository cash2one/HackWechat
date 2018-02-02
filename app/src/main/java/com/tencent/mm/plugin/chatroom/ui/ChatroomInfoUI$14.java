package com.tencent.mm.plugin.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.g.a.ri;
import com.tencent.mm.pluginsdk.q$a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class ChatroomInfoUI$14 implements OnClickListener {
    final /* synthetic */ ChatroomInfoUI lal;
    final /* synthetic */ boolean lap;

    ChatroomInfoUI$14(ChatroomInfoUI chatroomInfoUI, boolean z) {
        this.lal = chatroomInfoUI;
        this.lap = z;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (ChatroomInfoUI.b(this.lal) == null || ChatroomInfoUI.b(this.lal).length() <= 0) {
            x.e("MicroMsg.ChatroomInfoUI", "quitChatRoom : invalid args");
            return;
        }
        if (this.lap) {
            b riVar = new ri();
            riVar.fJc.fJf = true;
            a.xef.m(riVar);
        }
        ar.Hg();
        if (c.EY().WQ(ChatroomInfoUI.b(this.lal))) {
            ChatroomInfoUI.y(this.lal);
            if (q$a.vcx != null) {
                q$a.vcx.Fr(ChatroomInfoUI.b(this.lal));
                return;
            }
            return;
        }
        x.e("MicroMsg.ChatroomInfoUI", "quitChatRoom : room[" + ChatroomInfoUI.b(this.lal) + "] is not exist");
    }
}
