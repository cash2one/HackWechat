package com.tencent.mm.ui.contact;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMSlideDelView.e;

class ChatroomContactUI$10 implements e {
    final /* synthetic */ ChatroomContactUI yRt;

    ChatroomContactUI$10(ChatroomContactUI chatroomContactUI) {
        this.yRt = chatroomContactUI;
    }

    public final void bo(Object obj) {
        if (obj == null) {
            x.e("MicroMsg.ChatroomContactUI", "onItemDel object null");
            return;
        }
        ChatroomContactUI.Zz(obj.toString());
        ChatroomContactUI.c(this.yRt);
    }
}
