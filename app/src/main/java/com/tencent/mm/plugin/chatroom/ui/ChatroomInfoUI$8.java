package com.tencent.mm.plugin.chatroom.ui;

import android.widget.Toast;
import com.tencent.mm.g.a.lj;
import com.tencent.mm.g.a.sc;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.z.ar;

class ChatroomInfoUI$8 extends c<lj> {
    final /* synthetic */ ChatroomInfoUI lal;

    ChatroomInfoUI$8(ChatroomInfoUI chatroomInfoUI) {
        this.lal = chatroomInfoUI;
        this.xen = lj.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        lj ljVar = (lj) bVar;
        CharSequence charSequence = ljVar.fCK.fCM;
        int i = ljVar.fCK.ret;
        if (i == 0 || charSequence == null) {
            if (i == 0 && ChatroomInfoUI.t(this.lal)) {
                if (this.lal.lac == 27) {
                    a.xef.m(new sc());
                    ChatroomInfoUI.o(this.lal).dc(this.lal.lad);
                    ar.Hg();
                    com.tencent.mm.z.c.EY().Q(ChatroomInfoUI.o(this.lal));
                    ChatroomInfoUI.i(this.lal);
                } else if (this.lal.lac == 48 && ChatroomInfoUI.c(this.lal) != null) {
                    ChatroomInfoUI.c(this.lal).field_chatroomname = ChatroomInfoUI.b(this.lal);
                    ChatroomInfoUI.c(this.lal).field_selfDisplayName = ChatroomInfoUI.u(this.lal);
                    ar.Hg();
                    com.tencent.mm.z.c.Fh().c(ChatroomInfoUI.c(this.lal), new String[0]);
                    ChatroomInfoUI.v(this.lal);
                }
            }
        } else if (ChatroomInfoUI.r(this.lal) != null && this.lal.lac == 27) {
            ar.Hg();
            com.tencent.mm.z.c.EX().c(ChatroomInfoUI.r(this.lal));
        } else if (ChatroomInfoUI.s(this.lal) != null && this.lal.lac == 48) {
            ar.Hg();
            com.tencent.mm.z.c.EX().c(ChatroomInfoUI.s(this.lal));
            Toast.makeText(this.lal.mController.xIM, charSequence, 1).show();
        }
        if (ChatroomInfoUI.w(this.lal) != null) {
            ChatroomInfoUI.w(this.lal).dismiss();
        }
        return false;
    }
}
