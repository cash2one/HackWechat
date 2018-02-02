package com.tencent.mm.plugin.chatroom.ui;

import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.b;

class ChatroomInfoUI$9 implements b {
    final /* synthetic */ ChatroomInfoUI lal;
    final /* synthetic */ String lam;

    ChatroomInfoUI$9(ChatroomInfoUI chatroomInfoUI, String str) {
        this.lal = chatroomInfoUI;
        this.lam = str;
    }

    public final boolean v(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        String zI = com.tencent.mm.k.b.zI();
        if (bh.ov(zI) || !charSequence2.matches(".*[" + zI + "].*")) {
            if (!(charSequence2 == null || charSequence2.equals(this.lam))) {
                ChatroomInfoUI.a(this.lal, charSequence2);
            }
            return true;
        }
        h.bu(this.lal.mController.xIM, this.lal.getString(R.l.epE, new Object[]{zI}));
        return false;
    }
}
