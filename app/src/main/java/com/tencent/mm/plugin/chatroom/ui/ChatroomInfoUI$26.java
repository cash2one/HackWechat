package com.tencent.mm.plugin.chatroom.ui;

import com.tencent.mm.R;
import com.tencent.mm.g.a.jz;
import com.tencent.mm.pluginsdk.d.b;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.h;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

class ChatroomInfoUI$26 extends b {
    final /* synthetic */ ChatroomInfoUI lal;

    ChatroomInfoUI$26(ChatroomInfoUI chatroomInfoUI) {
        this.lal = chatroomInfoUI;
        super(0);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.sdk.b.b bVar) {
        if (bVar instanceof jz) {
            jz jzVar = (jz) bVar;
            x.i("MicroMsg.ChatroomInfoUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
            if (ChatroomInfoUI.A(this.lal) != null) {
                ChatroomInfoUI.A(this.lal).dismiss();
            }
            if (i == 0 && i2 == 0) {
                if (i == 0 && i2 == 0 && ChatroomInfoUI.m(this.lal) != null) {
                    ArrayList aq = ChatroomInfoUI.aq(jzVar.fBl.fAX);
                    ContactListExpandPreference m = ChatroomInfoUI.m(this.lal);
                    if (m.vol != null) {
                        h hVar = m.vol.vnx;
                        hVar.ac(aq);
                        hVar.notifyChanged();
                    }
                    if (ChatroomInfoUI.f(this.lal) != null) {
                        ChatroomInfoUI.f(this.lal).notifyDataSetChanged();
                    }
                    this.lal.setMMTitle(this.lal.getResources().getQuantityString(R.j.duI, aq.size(), new Object[]{Integer.valueOf(aq.size())}));
                }
                ChatroomInfoUI.j(this.lal);
            } else if (i2 == -21) {
                com.tencent.mm.ui.base.h.a(this.lal, this.lal.getString(R.l.eFz), this.lal.getString(R.l.dGO), new 1(this));
            } else {
                com.tencent.mm.ui.base.h.b(this.lal, this.lal.getString(R.l.eFB), this.lal.getString(R.l.dGO), true);
            }
        }
    }
}
